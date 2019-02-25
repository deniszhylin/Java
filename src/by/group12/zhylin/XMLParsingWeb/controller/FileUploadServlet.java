package by.group12.zhylin.XMLParsingWeb.controller;


import by.group12.zhylin.XMLParsingWeb.builder.PaperStAXBuilder;
import by.group12.zhylin.XMLParsingWeb.builder.PapersDOMBuilder;
import by.group12.zhylin.XMLParsingWeb.builder.PapersSAXBuilder;
import by.group12.zhylin.XMLParsingWeb.divider.FileNameDivide;
import by.group12.zhylin.XMLParsingWeb.entity.Paper;
import by.group12.zhylin.XMLParsingWeb.util.ConstatntVariable;
import by.group12.zhylin.XMLParsingWeb.util.JspPath;
import by.group12.zhylin.XMLParsingWeb.validation.XMLValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String XSD_SCHEME_FILE_PATH = "upload\\task.xsd";
    private static final String UPLOAD_DIR_NAME = "upload";
    private static final String SLASH_SYMBOL = "\\";
    private static final String DOM_PARSER_STRING = "DOM";
    private static final String SAX_PARSER_STRING = "SAX";
    private static final String STAX_PARSER_STRING = "StAX";
    private static final String PARSER_TYPE_STRING = "parserType";
    private static final String PAPERS_STRING = "papers";
    private static final String PARSER_STRING = "parser";
    private static final String OUT_STRING = "out";
    private static final String CONTENT_STRING = "content";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String servletPath = request.getServletContext().getRealPath("/");
        String projectPath = "";
        String selectedParser = request.getParameter(PARSER_STRING);

        for (String line : servletPath.split(ConstatntVariable.SLASH_REG_EXP.getValue())) {
            if (line.equalsIgnoreCase(OUT_STRING)) {
                break;
            }
            projectPath = projectPath.concat(line).concat(SLASH_SYMBOL);

        }

        Part part = request.getPart(CONTENT_STRING);

        String fileName = FileNameDivide.getFileNameByPart(part);
        if (FileNameDivide.isValidFileName(fileName)) {
            String absoluteXmlPath = projectPath + UPLOAD_DIR_NAME + File.separator + fileName;
            String absoluteXsdPath = projectPath + XSD_SCHEME_FILE_PATH;
            part.write(absoluteXmlPath);
            boolean isValidXmlByXsd = new XMLValidator(Paths.get(absoluteXmlPath), Paths.get(absoluteXsdPath))
                    .validate();
            if (!isValidXmlByXsd) {
                response.sendError(500, "Not valid xml file");
            }

            switch (selectedParser) {
                case DOM_PARSER_STRING: {
                    System.out.println("DOM-Parser");
                    request.setAttribute(PARSER_TYPE_STRING, DOM_PARSER_STRING);
                    PapersDOMBuilder papersDOMBuilder = new PapersDOMBuilder();
                    papersDOMBuilder.buldPapersList(absoluteXmlPath);
                    List<Paper> papers = papersDOMBuilder.getPapers();
                    request.setAttribute(PAPERS_STRING, papers);
                    break;
                }
                case SAX_PARSER_STRING: {
                    request.setAttribute(PARSER_TYPE_STRING, SAX_PARSER_STRING);
                    PapersSAXBuilder papersSAXBuilder = new PapersSAXBuilder();
                    papersSAXBuilder.buildPapersList(absoluteXmlPath);
                    List<Paper> papers = papersSAXBuilder.getPapers();
                    request.setAttribute(PAPERS_STRING, papers);
                    break;
                }
                case STAX_PARSER_STRING: {
                    request.setAttribute(PARSER_TYPE_STRING, STAX_PARSER_STRING);
                    PaperStAXBuilder paperStAXBuilder = new PaperStAXBuilder();
                    paperStAXBuilder.buildPapersList(absoluteXmlPath);
                    List<Paper> papers = paperStAXBuilder.getPapers();
                    request.setAttribute(PAPERS_STRING, papers);
                    break;
                }
                default: {
                    response.sendError(500);
                }
            }
            try {
                request.getRequestDispatcher(JspPath.TITLE_PAGE_PATH).forward(request, response);
            } catch (UnknownHostException e) {
                LOGGER.log(Level.FATAL, e);
                response.sendError(500);
            }
        }
    }
}