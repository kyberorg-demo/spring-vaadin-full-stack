package eu.yadev.app.security;

import eu.yadev.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}
