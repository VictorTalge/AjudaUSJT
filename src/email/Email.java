package email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Administrador;
import model.Usuario;

public class Email {
	private static String email = "ajudasaojudas1@gmail.com";
	private static String senha = "grupoweb31";

	public static void emailBoasVindas(Usuario usuario) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Email de Boas vindas | Ajuda S�o Judas");
			message.setText(
					"Ol� " + usuario.getNome() + " Sej� muito bem vindo, j� est� tudo pronto para o uso de sua conta!");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void alteracaoSenha(Usuario usuario) {
		Properties props = new Properties();
			System.out.print(usuario.toString());
		
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Senha| Ajuda S�o Judas");
			message.setText("Ol� " + usuario.getNome() + " sua senha � :" + usuario.getSenha());
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void avisoExclusao(Usuario usuario) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Exclus�o de Conta | Ajuda S�o Judas");
			message.setText("Ol� " + usuario.getNome() + " sua conta foi excluida," + "Sentiremos sua falta! \n" + "\n"
					+ " caso n�o tenha sido voc� entre em contato com um administrador!");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void alteracaoDados(Usuario usuario) {
		System.out.println(usuario.toString());
		
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Atualiza��o de Dados | Ajuda S�o Judas");
			message.setText("Ol� " + usuario.getNome()
					+ ", um ou mais dados foram alterados caso n�o tenha sido voc�, recomendamos que altere sua senha!");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void confirmaSolicitacao(String emailConfirma, String nome ) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(emailConfirma);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Solicita��o de Ajuda | Ajuda S�o Judas");
			message.setText("Ol�, "+  nome
					+ "sua solicita��o foi feita com sucesso!");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void novaSolicitacaoEnsina(String emailA, String nomeAjuda, String nomeRecebeAjuda) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(emailA);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Solicita��o de Ajuda | Ajuda S�o Judas");
			message.setText("Ol� " + nomeAjuda + ", " +nomeRecebeAjuda
					+ "est� solicitando sua ajuda, entre em nosso site para aceitar ou recusar!");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	//////////////// Adiministrador


	public static void emailBoasVindas(Administrador usuario) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Email de Boas vindas | Ajuda S�o Judas");
			message.setText(
					"Ol� " + usuario.getNome() + " Sej� muito bem vindo. Agora voc� faz parte do nosso time e nos ajudar� a admnistrar e supervisionar nosso sistema. j� est� tudo pronto para o uso de sua conta!");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	
	public static void alteracaoSenha(Administrador usuario) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Senha| Ajuda S�o Judas");
			message.setText("Ol� " + usuario.getNome() + " sua senha � :" + usuario.getSenha());
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void avisoExclusao(Administrador usuario) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Exclus�o de Conta | Ajuda S�o Judas");
			message.setText("Ol� " + usuario.getNome() + " sua conta foi excluida," + "Sentiremos sua falta! \n" + "\n"
					+ " caso n�o tenha sido voc� entre em contato com um administrador!");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void alteracaoDados(Administrador usuario) {
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, senha);
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinat�rio(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Atualiza��o de Dados | Ajuda S�o Judas");
			message.setText("Ol� " + usuario.getNome()
					+ ", um ou mais dados foram alterados caso n�o tenha sido voc�, recomendamos que altere sua senha!");
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
