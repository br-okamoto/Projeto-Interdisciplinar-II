package allshoes.web.servlet;

import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
public class Atendimento extends HttpServlet {
boolean rec;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  String Corrige(String x){
    if (x == null)
    { return ""; }
    
   if (rec == true)
   {return x; }
   else
       return "";
    }
  
  public static boolean validEmail(String email) {
    System.out.println("Metodo de validacao de email");
    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
    Matcher m = p.matcher(email); 
    if (m.find()){
         return true;
    }
    else{
         return false;
    }  
 } 
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Header header = new Header(false,"Atendimento");
        Footer footer = new Footer(false);
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Atendimento</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Atendimento");
            out.println("</div>");
            out.println("</div>");
          
            if ((!String.valueOf("").equals(request.getParameter("nome")) && request.getParameter("nome") != null) &&(!String.valueOf("").equals(request.getParameter("email")) && request.getParameter("email") != null) && (!String.valueOf("").equals(request.getParameter("assunto")) && request.getParameter("assunto") != null))  
            {
              
                if (validEmail(request.getParameter("email")))
                {            
                    // Enviar email
                    HtmlEmail email = new HtmlEmail();
                    email.setPopBeforeSmtp(false, "pop.servidor", "allshoes127@yahoo.com.br", "97c219"); //Troque pelos seus dados
                    email.setSmtpPort(25); //Porta do servidor smtp
                    email.setAuthenticator(new DefaultAuthenticator("allshoes127@yahoo.com.br", "97c219")); //troque por seus dados
                    email.setDebug(false);
                    email.setHostName("smtp.mail.yahoo.com.br"); //troque pelo endereco de seu servidor smtp
                    email.setFrom("allshoes127@yahoo.com.br"); //Coloque aqui o endereco do remetende do email
                    email.setSubject(request.getParameter("email") + " " + request.getParameter("categoria")); //Substitua aqui o Assunto da mensagem
                    email.addTo("allshoes127@yahoo.com.br"); //Troque o para pelo email que recebera a mensagem
                    //email.addCc("Com Copia"); //Aqui eh adicionado um email que sera copiado
                    //email.addCc("Com Copia"); //Para adicionar mais copias basta copiar varias vezes esta linha sempre trocando o "Com Copia" pelo endereco e recebimento
                    email.setTLS(true);

                    email.setHtmlMsg("<b>DE       :" + request.getParameter("nome") + " " + "<br>EMAIL  :" + request.getParameter("email") + " " + "<br>ASSUNTO:" + request.getParameter("assunto")); //Aqui eh definido o email no formato HTML
                    email.setTextMsg(request.getParameter("assunto")); //Esta mensagem aparece caso o email de recebimento nao suporte HTML

                    email.send();
                    rec = false;
                    out.println("INFORMAÇÔES ENVIADAS COM SUCESSO!");  
                }
                else
                { 
                    rec = true;
                    out.println("EMAIL INVÁLIDO!");
                }
               
            }
            else    
            { 
                if (String.valueOf(request.getParameter("valida")).equals("1"))
                {
                    out.println("TODOS OS CAMPOS DEVEM SER PRENCHIDOS!");
                    rec = true;
                }                
            }

            out.println("<form action='Atendimento' method='post'>");
            out.println("	<DIV id=u49 style=\"position:absolute; left:20px; top:310px; width:260px; height:37px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;\" >	");
            out.println("	<DIV id=u49_rtf><span style=\" font-family:'Arial'; color:#000000; font-size:16px;\"><b>CENTRAL DE ATENDIMENTO</b><br>TELEFONE (SAC): (11) 4000-0000</span></DIV></DIV>	");
            out.println("	<DIV id=u50 style=\"position:absolute; left:20px; top:370px; width:150px; height:19px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;\" >	");
            out.println("	<DIV id=u50_rtf><span style=\" color:#000000; font-size:16px;\"><b>FALE CONOSCO</b></span></DIV></DIV>	");
            out.println("	<DIV id=u51 style=\"position:absolute; left:20px; top:410px; width:100px; height:16px; ; ; text-align: left ; font-family:Arial; text-align:left; word-wrap:break-word;\" >	");
            out.println("	<DIV id=u51_rtf><div style=\"text-align:right\"><span style=\" color:#000000; font-size:13px;\">Nome</span></div></DIV></DIV>	");
            out.println("	<DIV id=u52 style=\"position:absolute; left:20px; top:445px; width:100px; height:16px; ; ; text-align: right ; font-family:Arial; text-align:left; word-wrap:break-word;\" >	");
            out.println("	<DIV id=u52_rtf><div style=\"text-align:right\"><span style=\" font-family:'Arial'; color:#000000; font-size:13px;\">E-mail</span></div></DIV></DIV>	");
            out.println("	<DIV id=u53 style=\"position:absolute; left:20px; top:514px; width:100px; height:16px; ; ; text-align: right ; font-family:Arial; text-align:left; word-wrap:break-word;\" >	");
            out.println("	<DIV id=u53_rtf><div style=\"text-align:right\"><span style=\" font-family:'Arial'; color:#000000; font-size:13px;\">Assunto</span></div></DIV></DIV>	");
            out.println("	<DIV id=u54 style=\"position:absolute; left:20px; top:479px; width:100px; height:16px; ; ; text-align: right ; font-family:Arial; text-align:left; word-wrap:break-word;\" >	");
            out.println("	<DIV id=u54_rtf><div style=\"text-align:right\"><span style=\" font-family:'Arial'; color:#000000; font-size:13px;\">Categoria</span></div></DIV></DIV>	");
            out.println("	<INPUT id=u55 name=\"nome\" value=\"" + Corrige(request.getParameter("nome")) + "\" type=text style=\"position:absolute; left:140px; top:406px; width:370px; height:25px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none\"   >	");
            out.println("	<INPUT id=u56 name=\"email\" value=\"" + Corrige(request.getParameter("email")) + "\"type=text style=\"position:absolute; left:140px; top:440px; width:260px; height:25px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none\"   >	");
            out.println("	<SELECT id=u57 name=\"categoria\" selected=\"" + Corrige(request.getParameter("categoria")) + "\"style=\"position:absolute; left:140px; top:476px; width:180px; height:22px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none\" >	");
            out.println("	<OPTION  value=\"Duvidas sobre um produto\">Dúvidas sobre um produto</OPTION>	");
            out.println("	<OPTION  value=\"Duvidas sobre pagamentos\">Dúvidas sobre pagamentos</OPTION>	");
            out.println("	<OPTION  value=\"Duvidas sobre entregas\">Dúvidas sobre entregas</OPTION>	");
            out.println("	<OPTION  value=\"Reclamacao\">Reclamação</OPTION>	");
            out.println("	</SELECT>	");
            out.println("	<TEXTAREA id=u58 name=\"assunto\" value=\"" + Corrige(request.getParameter("assunto")) + "\" style=\"position:absolute; left:140px; top:514px; width:550px; height:130px; ; ; text-align: left ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none\"  ></TEXTAREA>	");
            out.println("	<INPUT type=\"hidden\" name=\"valida\" value=\"1\">");
            out.println("	<INPUT id=u59  type=submit value=\"Enviar\" style=\"position:absolute; left:590px; top:660px; width:100px; height:25px; ; ; text-align: center ; font-family:'Arial'; font-size: 13px; color:#000000; font-style:normal; font-weight:normal; text-decoration:none\" >	");
            out.println(" </form> ");

            out.println(footer.getFooterPadrao());

        } catch(Exception e){out.println(e);}finally {            
            out.close();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}