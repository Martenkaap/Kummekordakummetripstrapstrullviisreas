package ee.martenkaap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Mang extends HttpServlet
{
    private TripsTrapsTrull aktiivneMang = new TripsTrapsTrull();

    private String teeNupp(int asukoht)
    {
        String html = "<button name='nupp' value=" + asukoht + ">";
        int misMark = aktiivneMang.getVali(asukoht);
        switch(misMark)
        {
            case 0:
                html += "?";
                break;
            case 1:
                html += "X";
                break;
            case 2:
                html += "O";
                break;
        }
        html += "</button>";
        return html;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");


        if(request.getParameter("restart") != null)
        {
            aktiivneMang.restart();
        }

        if(request.getParameter("nupp") != null)
        {
            int misNupp = Integer.parseInt(request.getParameter("nupp"));
            aktiivneMang.teeKaik(misNupp);
        }

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write("<form>");
        for(int i=0; i<91; i=i+10) {
            for(int s=0; s<10; s=s+1){
                int k=s+i;
                if(k!=0) {
            response.getWriter().write(teeNupp(k));
                    if (k == 99) {
                        k++;
                        response.getWriter().write(teeNupp(k));
                    }
                    if (s == 0)
                    {response.getWriter().write("<br>");

        }}}}



        response.getWriter().write("<button name='restart'>restart</button>");

        response.getWriter().write("</form>");
        response.getWriter().write("<br>");


        if(aktiivneMang.kasmangkäibveel()==true)
        {
            response.getWriter().write("<h1>Voitja on:" +aktiivneMang.kesvoitis()+"</h1>");
        }


    }
}
