package com.ghfelipe.formulario.controller;

import net.sf.jasperreports.engine.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
    private final DataSource dataSource;

    public ReportController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/aluno/pdf")
    public ResponseEntity<byte[]> generateReport() {
        try {
            // Logando o início do processo de geração do relatório
            logger.info("Iniciando geração do relatório PDF.");

            // Carregar o template do relatório (.jrxml)
            InputStream reportStream = new ClassPathResource("RelatorioAluno.jrxml").getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Parametros do relatório (se houver)
            Map<String, Object> parameters = new HashMap<>();

            // Preencher o relatório com dados (neste caso, vazio)
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Exportar o relatório para PDF
            byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);

            // Logando a conclusão do processo de geração do relatório
            logger.info("Relatório PDF gerado com sucesso.");

            // Retornar o PDF como resposta
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return ResponseEntity.ok().headers(headers).body(pdfReport);
        } catch (Exception e) {
            logger.error("Erro ao gerar relatório PDF.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
