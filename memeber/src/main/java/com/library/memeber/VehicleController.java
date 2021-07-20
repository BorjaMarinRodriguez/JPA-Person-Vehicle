package com.library.memeber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	@RequestMapping("/vehicle")
	public class VehicleController {
		
		@Autowired
		VehicleRepository vehicleRepository;

		@RequestMapping("/allVehicles")
		public String getAllVehicles(Model boxToView) {
			
			boxToView.addAttribute("vehiclesfromController", vehicleRepository.findAll() );
			
			return "vehicle.html";
		}
		
		@RequestMapping("/newVehicle")
		public String newVehicle () {

			return "newvehicle.html";
		}

		@RequestMapping("/addVehicle")
		public String inserVehicle( @Validated Vehicle vehicle) {
			
			//System.out.println(vehicle);
			vehicleRepository.save(vehicle);

			return "redirect:/vehicle/allVehicle";
		}

}