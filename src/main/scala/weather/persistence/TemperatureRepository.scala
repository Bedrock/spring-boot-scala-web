package weather.persistence

import java.lang.Long

import org.springframework.data.repository.CrudRepository
import weather.domain.Temperature

trait TemperatureRepository extends CrudRepository[Temperature, Long]