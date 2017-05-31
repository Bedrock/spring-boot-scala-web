package weather.client.rest

import java.lang.Long
import javax.validation.Valid

import mvctest.domain.Hotel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation._
import weather.domain.Temperature
import weather.persistence.TemperatureRepository

@Controller
@RequestMapping(Array("/temperatures"))
class TemperatureController @Autowired()(private val temperatureRepository: TemperatureRepository) {

  @GetMapping
  def list(model: Model) = {
    val hotels = temperatureRepository.findAll()
    model.addAttribute("temperatures", hotels)
    "temperatures/list"
  }

  @GetMapping(Array("/edit/{id}"))
  def edit(@PathVariable("id") id: Long, model: Model) = {
    model.addAttribute("temperature", temperatureRepository.findOne(id))
    "temperatures/edit"
  }

  @GetMapping(params = Array("form"))
  def createForm(model: Model) = {
    model.addAttribute("temperature", new Hotel())
    "temperatures/create"
  }

  @PostMapping
  def create(@Valid temperature: Temperature, bindingResult: BindingResult) =
    if (bindingResult.hasErrors()) {
      "temperatures/create"
    } else {
      temperatureRepository.save(temperature)
      "redirect:/temperatures"
    }


  @PostMapping(value = Array("/update"))
  def update(@Valid temperature: Temperature, bindingResult: BindingResult) =
    if (bindingResult.hasErrors()) {
      "temperatures/edit"
    } else {
      temperatureRepository.save(temperature)
      "redirect:/temperatures"
    }


  @GetMapping(value = Array("/delete/{id}"))
  def delete(@PathVariable("id") id: Long) = {
    temperatureRepository.delete(id)
    "redirect:/temperatures"
  }

}