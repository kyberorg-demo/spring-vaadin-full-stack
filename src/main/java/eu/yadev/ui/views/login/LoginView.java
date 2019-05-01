package eu.yadev.ui.views.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import eu.yadev.app.security.SecurityUtils;
import eu.yadev.ui.components.BakeryCookieConsent;
import eu.yadev.ui.utils.BakeryConst;
import eu.yadev.ui.views.storefront.StorefrontView;

@Route
@PageTitle("full-stack-spring")
@HtmlImport("styles/shared-styles.html")
@Viewport(BakeryConst.VIEWPORT)
public class LoginView extends VerticalLayout
	implements AfterNavigationObserver, BeforeEnterObserver {

	private LoginOverlay login = new LoginOverlay();

	public LoginView() {
		getElement().appendChild(
			new BakeryCookieConsent().getElement(), login.getElement());

		LoginI18n i18n = LoginI18n.createDefault();
		i18n.setHeader(new LoginI18n.Header());
		i18n.getHeader().setTitle("full-stack-spring");
		i18n.getHeader().setDescription(
			"admin@vaadin.com + admin\n" + "barista@vaadin.com + barista");
		i18n.setAdditionalInformation(null);
		i18n.setForm(new LoginI18n.Form());
		i18n.getForm().setSubmit("Sign in");
		i18n.getForm().setTitle("Sign in");
		i18n.getForm().setUsername("Email");
		i18n.getForm().setPassword("Password");
		login.setI18n(i18n);
		login.setForgotPasswordButtonVisible(false);
		login.setAction("login");
		login.setOpened(true);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (SecurityUtils.isUserLoggedIn()) {
			// Needed manually to change the URL because of https://github.com/vaadin/flow/issues/4189
			UI.getCurrent().getPage().getHistory().replaceState(null, "");
			event.rerouteTo(StorefrontView.class);
		}
	}

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		login.setError(
			event.getLocation().getQueryParameters().getParameters().containsKey(
				"error"));
	}

	public interface Model extends TemplateModel {

		void setError(boolean error);
	}

}
