package com.german.spring.hibernate.restcontroller;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.german.spring.hibernate.Service.IEmpleadoService;
import com.german.spring.hibernate.entity.Empleado;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GestionaEmpleado {

	@Autowired
	private IEmpleadoService iEmpleadoService;

	@RequestMapping(value = "/obtieneEmpleados", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneEmpleados() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("listaempleados", iEmpleadoService.readAll());
		return new JSONObject(map) + "";
	}

	@RequestMapping(value = "/creaEmpleado", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String creaEmpleado(@RequestBody(required = true) Empleado empleado) throws SQLException {
		log.info("Entro a Crea Empleado");
		Map<String, Object> map = new LinkedHashMap<>();
		iEmpleadoService.create(empleado);
		map.put("empleado", iEmpleadoService.obtieneEmpleado(1));
		return new JSONObject(map) + "";
	}

}
