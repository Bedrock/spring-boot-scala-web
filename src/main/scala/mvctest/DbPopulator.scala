package mvctest

import mvctest.domain.Hotel
import mvctest.service.HotelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import weather.domain.Temperature
import weather.persistence.TemperatureRepository

/**
  * Responsible for populating some initial data into the database..
  */

@Component
class DbPopulator @Autowired()(val hotelRepository: HotelRepository, val temperatureRepository: TemperatureRepository) extends CommandLineRunner {
  override def run(args: String*): Unit = {
    (1 to 10).foreach(i => {
      hotelRepository.save(new Hotel(id = null, name = s"Hotel $i", address = s"Address $i", zip = s"Zip $i"))
      temperatureRepository.save(new Temperature(id = null, name = s"Hotel $i", address = s"Address $i", zip = s"Zip $i"))
    })
  }
}
