package eleks.com.EmailBuilder;

public class EmailBuilder implements IEmailBuilder {

	Email email;

	public EmailBuilder() {
		email = new Email();
	}

	public EmailBuilder buildTo(String to) {
		email.setTo(to);
		return this;
	}

	public EmailBuilder buildSubject(String subject) {
		email.setSubject(subject);
		return this;
	}

	public EmailBuilder buildBody(String body) {
		email.setBody(body);
		return this;
	}

	public Email build() {
		return this.email;
	}

}
