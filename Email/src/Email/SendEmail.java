package Email;
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport; 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String recipient = "upadhyay076@gmail.com"; 
		  
	      // email ID of  Sender. 
	      String sender = "dhaya98@gmail.com"; 
	  
	      // using host as localhost 
	      String host = "127.0.0.1"; 
	  
	      // Getting system properties 
	      Properties properties = System.getProperties(); 
	  
	      // Setting up mail server 
	      properties.setProperty("mail.smtp.host", host); 
	  
	      // creating session object to get properties 
	      Session session = Session.getDefaultInstance(properties); 
	  
	      try 
	      { 
	         // MimeMessage object. 
	         MimeMessage message = new MimeMessage(session); 
	  
	         // Set From Field: adding senders email to from field. 
	         message.setFrom(new InternetAddress(sender)); 
	  
	         // Set To Field: adding recipient's email to from field. 
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
	  
	         // Set Subject: subject of the email 
	         message.setSubject("This is Suject"); 
	  
	         // set body of the email. 
	         message.setText("This is a test mail"); 
	  
	         // Send email. 
	         Transport.send(message); 
	         System.out.println("Mail successfully sent"); 
	      } 
	      catch (MessagingException mex)  
	      { 
	         mex.printStackTrace(); 
	      } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
