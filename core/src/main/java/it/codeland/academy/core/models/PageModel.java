package it.codeland.academy.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageModel {
  @ValueMapValue(name = "jcr:title")
  private String Value;

  public String getValue() {
    return Value;
  };

  @ValueMapValue(name = "jcr:description")
  @Default(values = "No Description found")
  private String description;

  public String getDescription() {
    return description;
  };

  @ValueMapValue(name = "jcr:text")
  private String text;

  public String getText() {
    return text;
  };

}
