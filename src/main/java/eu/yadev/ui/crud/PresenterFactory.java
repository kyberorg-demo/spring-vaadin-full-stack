/**
 *
 */
package eu.yadev.ui.crud;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import eu.yadev.app.security.CurrentUser;
import eu.yadev.backend.data.entity.Order;
import eu.yadev.backend.service.OrderService;
import eu.yadev.ui.views.storefront.StorefrontView;

@Configuration
public class PresenterFactory {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public EntityPresenter<Order, StorefrontView> orderEntityPresenter(OrderService crudService, CurrentUser currentUser) {
		return new EntityPresenter<>(crudService, currentUser);
	}

}
