package weather.domain

import java.lang.Long
import javax.persistence.{Entity, GeneratedValue, Id}

import org.hibernate.validator.constraints.NotEmpty

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Entity
class Temperature(@(Id @field) @(GeneratedValue @field) @BeanProperty var id: Long,
                  @BeanProperty @(NotEmpty @field) var name: String,
                  @BeanProperty @(NotEmpty @field) var address: String,
                  @BeanProperty @(NotEmpty @field) var zip: String) {

  def this() = this(null, null, null, null)
}