package com.library.memeber;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	@RequestMapping("/vehicle")
	public class VehicleController {
		
		@Autowired
		VehicleRepository vehicleRepository;

		@RequestMapping("/allVehicles")
		public String getAllVehicles(Model boxToView) {
			
			System.out.println("Array1: " +  vehicleRepository.findAll());
			
			boxToView.addAttribute("vehiclesfromController", vehicleRepository.findAll() );
			
			System.out.println("Array2: " +  vehicleRepository.findAll());
			
			return "vehicles.html";
		}
		
		// Borrar vehicles
		@RequestMapping("/deleteVehicle")
		public String removeVehicle(int id, Model model) {

				// System.out.println("inside removeVehicle" + id);
				Optional<Vehicle> vehicleFound = findOneVehicleById(id);

				// System.out.println("find inside removeVehicle" + vehicleFound.get());

				if (vehicleFound.isPresent()) {

					vehicleRepository.deleteById(id);
					model.addAttribute("message", "done");
					model.addAttribute("vehicleDeleted", vehicleFound.get());
				}

				else {
					model.addAttribute("message", "error");
				}

				// System.out.println("finishing removeVehicle" + id);
				return "deletevehicle.html";
			}

			@RequestMapping("/deleteAllVehicles")
			public String deleteAllVehicles () {

				
				vehicleRepository.deleteAll();
				

				return "redirect:/vehicle/allVehicle";

			}
			
			// Afegir Vehicles
			
			@RequestMapping("/newVehicle")
			public String newVehicle() {

				return "newvehicle.html";
			}

			@RequestMapping("/addVehicle")
			public String inserVehicle(Vehicle vehicle) {

				vehicleRepository.save(vehicle);

				return "redirect:/vehicle/allVehicles";
			}

			// modificar Vehicles
			@RequestMapping("/updateVehicle")
			public String updateVehicle(int id, Model model) {

				Optional<Vehicle> vehicleFound = findOneVehicleById(id);

				if (vehicleFound.isPresent()) {

					model.addAttribute("vehiclefromController", vehicleFound.get());
					return "updatevehicle";
				}

				else
					return "notfound.html";
			}

			@PostMapping("/replaceVehicle/{idFromView}")
			public String replaceVehicle(@PathVariable("idFromView") int id, Vehicle vehicle) {

				Optional<Vehicle> vehicleFound = findOneVehicleById(id);

				if (vehicleFound.isPresent()) {

					if (vehicle.getName() != null)
						vehicleFound.get().setName(vehicle.getName());
					if (vehicle.getType() != null)
						vehicleFound.get().setType(vehicle.getType());
					if (vehicle.getType() != null)
						vehicleFound.get().setType2(vehicle.getType2());
					if (vehicle.getValue() != 0)
						vehicleFound.get().setValue(vehicle.getValue());
					

					vehicleRepository.save(vehicleFound.get());
					return "redirect:/vehicle/allVehicle";

				} else
					return "notfound.html";

			}
			
			// Informació de Vehicle
			@RequestMapping("/detailVehicle")
			public String detailVehicle(int id, Model model) {

				Optional<Vehicle> vehicleFound = findOneVehicleById(id);

				if (vehicleFound.isPresent()) {

					model.addAttribute("vehiclefromController", vehicleFound.get());
					return "detailvehicle";
				}

				else
					return "notfound.html";
			}
			
		
		//Servei al controllador, el que fà, es declarar una funció  amb el paràmetre Id, per que busqui a vehicleRepository el vehicle del Id y la 
			//guardi a vehicleFound
		

			public Optional<Vehicle> findOneVehicleById(int id) {

				// System.out.println("inside findPerson" + id);
				Optional<Vehicle> vehicleFound = vehicleRepository.findById(id);
				// System.out.println("finishing findPerson" + id);
				// System.out.println("finishing findPerson" + personFound.get());
				return vehicleFound;
			}

}