package it.codeland.academy.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.wcm.core.components.models.Page;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Author.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorImpl implements Author {

  @ScriptVariable
  Page currentPage;

  @RequestAttribute(name = "hardCodedTitle")
  private String reqTitle;

  @Inject
  @Via("resource")
  @Required
  @Default(values = "Richard")
  String fname;

  @ValueMapValue
  @Default(values = "Munyemana")
  String lname;

  @Override
  public String getFirstName() {
    return fname;
  }

  @Override
  public String getLastName() {
    return lname;
  }

  @Override
  public String getCurrentPageTitle() {
    return currentPage.getTitle();
  }

  @Override
  public String getRequestTitle() {
    return reqTitle;
  }

}
