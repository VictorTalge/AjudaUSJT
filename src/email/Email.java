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
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Email de Boas vindas | Ajuda São Judas");
			message.setText(
					"Olá " + usuario.getNome() + " Sejá muito bem vindo, já está tudo pronto para o uso de sua conta!");
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void alteracaoSenha(Usuario usuario) {
		Properties props = new Properties();
			System.out.print(usuario.toString());
		
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Senha| Ajuda São Judas");
			message.setText("Olá " + usuario.getNome() + " sua senha é :" + usuario.getSenha());
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void avisoExclusao(Usuario usuario) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Exclusão de Conta | Ajuda São Judas");
			message.setText("Olá " + usuario.getNome() + " sua conta foi excluida," + "Sentiremos sua falta! \n" + "\n"
					+ " caso não tenha sido você entre em contato com um administrador!");
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void alteracaoDados(Usuario usuario) {
		System.out.println(usuario.toString());
		
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Atualização de Dados | Ajuda São Judas");
			message.setText("Olá " + usuario.getNome()
					+ ", um ou mais dados foram alterados caso não tenha sido você, recomendamos que altere sua senha!");
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void confirmaSolicitacao(String emailConfirma, String nome ) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(emailConfirma);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Solicitação de Ajuda | Ajuda São Judas");
			message.setText("Olá, "+  nome
					+ "sua solicitação foi feita com sucesso!");
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void novaSolicitacaoEnsina(String emailA, String nomeAjuda, String nomeRecebeAjuda) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(emailA);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Solicitação de Ajuda | Ajuda São Judas");
			message.setText("Olá " + nomeAjuda + ", " +nomeRecebeAjuda
					+ "está solicitando sua ajuda, entre em nosso site para aceitar ou recusar!");
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	//////////////// Adiministrador


	public static void emailBoasVindas(Administrador usuario) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Email de Boas vindas | Ajuda São Judas");
			message.setText(
					"Olá " + usuario.getNome() + " Sejá muito bem vindo. Agora você faz parte do nosso time e nos ajudará a admnistrar e supervisionar nosso sistema. já está tudo pronto para o uso de sua conta!");
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	
	public static void alteracaoSenha(Administrador usuario) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Senha| Ajuda São Judas");
			message.setText("Olá " + usuario.getNome() + " sua senha é :" + usuario.getSenha());
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void avisoExclusao(Administrador usuario) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Exclusão de Conta | Ajuda São Judas");
			message.setText("Olá " + usuario.getNome() + " sua conta foi excluida," + "Sentiremos sua falta! \n" + "\n"
					+ " caso não tenha sido você entre em contato com um administrador!");
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void alteracaoDados(Administrador usuario) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */
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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			// Remetente
			// Destinatário(s)
			Address[] toUser = InternetAddress.parse(usuario.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Atualização de Dados | Ajuda São Judas");
			message.setText("Olá " + usuario.getNome()
					+ ", um ou mais dados foram alterados caso não tenha sido você, recomendamos que altere sua senha!");
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
