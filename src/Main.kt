import models.ManagerUser
import models.Project
import models.DevUser
import services.DevUserService
import services.ManagerUserService

fun main() {

	val devService: DevUserService = DevUserService()
	val managerService: ManagerUserService = ManagerUserService()

	var devLogged: DevUser
	var managerLogged: ManagerUser

	println("Do you wanna log in as a Dev (1) or as a Manager (2)?")
	var op: Int = readLine()!!.toInt();

	if (op == 1) {
		println("First of all, you need to create your account: ")
		devLogged = devService.createDevUser()
		devPainel(devLogged)
	}
	if (op == 2) {
		println("First of all, you need to create your account: ")
		managerLogged = managerService.createManagerUser()
		managerPainel(managerLogged)
	}
}


fun devPainel(devUser: DevUser) {
	var op: Int = 0;
	var devService: DevUserService = DevUserService()

	while (op != 4) {
		println("Create project (1)")
		println("Delete project (2)")
		println("See my profile (3)")
		println("Exit (4)")
		op = readLine()!!.toInt()


		if (op == 1) devService.createProject(devUser)
		if (op == 2) devService.deleteProject(devUser)
		if (op == 3) devUser.returnProfile();
	}


}

fun managerPainel(managerUser: ManagerUser) {
	var op: Int = 0;
	var managerService: ManagerUserService = ManagerUserService()

	while (op != 4) {
		println("Create project (1)")
		println("Delete project (2)")
		println("See my profile (3)")
		println("Exit (4)")
		op = readLine()!!.toInt()


		// if (op == 1) managerService.createProject(managerUser)
		// if (op == 2) managerService.deleteProject(managerUser)
		if (op == 3) managerUser.returnProfile();
	}


}



