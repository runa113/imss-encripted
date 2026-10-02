package com.imss_encripted.imss.controller;


import com.imss_encripted.imss.dto.ExpedienteRequestDto;
import com.imss_encripted.imss.dto.ExpedienteResponseDto;
import com.imss_encripted.imss.service.ExpedienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expedientes")
@RequiredArgsConstructor
public class InstitucionImssController {

    private final ExpedienteService expedienteService;

    @PostMapping("/imss")
    public ResponseEntity<ExpedienteResponseDto> obtenerExpediente(
            @RequestHeader("X-Api-Key") String apiKey,
            @RequestHeader("X-Trace-Id") String traceId,
            @RequestHeader("X-Solicitante") String solicitante,
            @Valid @RequestBody ExpedienteRequestDto request)
            throws Exception {

        ExpedienteResponseDto response =
                expedienteService.obtenerExpediente(
                        apiKey,
                        traceId,
                        solicitante,
                        request);

        return ResponseEntity.ok(response);
    }
}
