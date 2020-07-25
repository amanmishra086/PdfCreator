package com.example.pdfcreator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    //private DatabaseReference databaseReference;
    private String name,cnic,status,class1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=findViewById(R.id.webview);
        name="Aman";
        cnic="**********";
        status="student";
        class1="Btech";

        String html="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title></title>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"file:android_asset/CreatePdf.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div>\n" +
                "\t\t<h3>View My Record</h3>\n" +
                "\t\t<table border=\"1\">\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>Name</td>\n" +
                "\t\t\t\t<td id=\"name\">"+name+"</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>Age</td>\n" +
                "\t\t\t\t<td id=\"age\">"+status+"</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>CNIC</td>\n" +
                "\t\t\t\t<td id=\"cnic\">"+cnic+"</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td>Class</td>\n" +
                "\t\t\t\t<td id=\"class\">"+class1+"</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table>\n" +
                "\t</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        String html2="<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>A simple, clean, and responsive HTML invoice template</title>\n" +
                "    \n" +
                "    <style>\n" +
                "    .invoice-box {\n" +
                "        max-width: 800px;\n" +
                "        margin: auto;\n" +
                "        padding: 30px;\n" +
                "        border: 1px solid #eee;\n" +
                "        box-shadow: 0 0 10px rgba(0, 0, 0, .15);\n" +
                "        font-size: 16px;\n" +
                "        line-height: 24px;\n" +
                "        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n" +
                "        color: #555;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table {\n" +
                "        width: 100%;\n" +
                "        line-height: inherit;\n" +
                "        text-align: left;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table td {\n" +
                "        padding: 5px;\n" +
                "        vertical-align: top;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr td:nth-child(2) {\n" +
                "        text-align: right;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr.top table td {\n" +
                "        padding-bottom: 20px;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr.top table td.title {\n" +
                "        font-size: 45px;\n" +
                "        line-height: 45px;\n" +
                "        color: #333;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr.information table td {\n" +
                "        padding-bottom: 40px;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr.heading td {\n" +
                "        background: #eee;\n" +
                "        border-bottom: 1px solid #ddd;\n" +
                "        font-weight: bold;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr.details td {\n" +
                "        padding-bottom: 20px;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr.item td{\n" +
                "        border-bottom: 1px solid #eee;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr.item.last td {\n" +
                "        border-bottom: none;\n" +
                "    }\n" +
                "    \n" +
                "    .invoice-box table tr.total td:nth-child(2) {\n" +
                "        border-top: 2px solid #eee;\n" +
                "        font-weight: bold;\n" +
                "    }\n" +
                "    \n" +
                "    @media only screen and (max-width: 600px) {\n" +
                "        .invoice-box table tr.top table td {\n" +
                "            width: 100%;\n" +
                "            display: block;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        \n" +
                "        .invoice-box table tr.information table td {\n" +
                "            width: 100%;\n" +
                "            display: block;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    }\n" +
                "    \n" +
                "    /** RTL **/\n" +
                "    .rtl {\n" +
                "        direction: rtl;\n" +
                "        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n" +
                "    }\n" +
                "    \n" +
                "    .rtl table {\n" +
                "        text-align: right;\n" +
                "    }\n" +
                "    \n" +
                "    .rtl table tr td:nth-child(2) {\n" +
                "        text-align: left;\n" +
                "    }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <div class=\"invoice-box\">\n" +
                "        <table cellpadding=\"0\" cellspacing=\"0\">\n" +
                "            <tr class=\"top\">\n" +
                "                <td colspan=\"2\">\n" +
                "                    <table>\n" +
                "                        <tr>\n" +
                "                            <td class=\"title\">\n" +
                "                                <img src=\"https://www.sparksuite.com/images/logo.png\" style=\"width:100%; max-width:300px;\">\n" +
                "                            </td>\n" +
                "                            \n" +
                "                            <td>\n" +
                "                                Invoice #: 123"+name+"<br>\n" +
                "                                Created: January 1, 2015<br>\n" +
                "                                Due: February 1, 2015\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"information\">\n" +
                "                <td colspan=\"2\">\n" +
                "                    <table>\n" +
                "                        <tr>\n" +
                "                            <td>\n" +
                "                                Sparksuite, Inc.<br>\n" +
                "                                12345 Sunny Road<br>\n" +
                "                                Sunnyville, CA 12345\n" +
                "                            </td>\n" +
                "                            \n" +
                "                            <td>\n" +
                "                                Acme Corp.<br>\n" +
                "                                John Doe<br>\n" +
                "                                john@example.com\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"heading\">\n" +
                "                <td>\n" +
                "                    Payment Method\n" +
                "                </td>\n" +
                "                \n" +
                "                <td>\n" +
                "                    Check #\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"details\">\n" +
                "                <td>\n" +
                "                    Check\n" +
                "                </td>\n" +
                "                \n" +
                "                <td>\n" +
                "                    1000\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"heading\">\n" +
                "                <td>\n" +
                "                    Item\n" +
                "                </td>\n" +
                "                \n" +
                "                <td>\n" +
                "                    Price\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"item\">\n" +
                "                <td>\n" +
                "                    Website design\n" +
                "                </td>\n" +
                "                \n" +
                "                <td>\n" +
                "                    $300.00\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"item\">\n" +
                "                <td>\n" +
                "                    Hosting (3 months)\n" +
                "                </td>\n" +
                "                \n" +
                "                <td>\n" +
                "                    $75.00\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"item last\">\n" +
                "                <td>\n" +
                "                    Domain name (1 year)\n" +
                "                </td>\n" +
                "                \n" +
                "                <td>\n" +
                "                    $10.00\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"total\">\n" +
                "                <td></td>\n" +
                "                \n" +
                "                <td>\n" +
                "                   Total: $385.00\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";

        webView.loadDataWithBaseURL(null,html2,"text/html","utf-8",null);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void CreatePdf(View view){
        Context context=MainActivity.this;
        PrintManager printManager=(PrintManager)MainActivity.this.getSystemService(context.PRINT_SERVICE);
        PrintDocumentAdapter adapter=null;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            adapter=webView.createPrintDocumentAdapter();
        }
        String JobName=getString(R.string.app_name) +"Document";
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            PrintJob printJob=printManager.print(JobName,adapter,new PrintAttributes.Builder().build());
        }

    }

}
