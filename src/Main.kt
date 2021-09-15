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

	println("First of all, you need to create your account: ")

	if (op == 1) {
		devLogged = devService.createDevUser()
		devDashboard(devLogged)
	}
	if (op == 2) {
		managerLogged = managerService.createManagerUser()
		managerDashboard(managerLogged)
	}
}


fun devDashboard(devUser: DevUser) {
	var op: Int = 0;
	var devService: DevUserService = DevUserService()

	while (op != 4) {
		println("Create project (1)")
		println("Delete project (2)")
		println("See my profile (3)")
		println("Exit (4)")
		op = readLine()!!.toInt()

		when (op) {
			1 -> devService.createProject(devUser)
			2 -> devService.deleteProject(devUser)
			3 -> devUser.returnProfile()
		}

	}


}

fun managerDashboard(managerUser: ManagerUser) {
	var op: Int = 0;
	var managerService: ManagerUserService = ManagerUserService()

	while (op != 6) {
		println("Create project (1)")
		println("Delete project (2)")
		println("Create developer (3)")
		println("Delete developer (4)")
		println("Change my credits (5)")
		println("Change my dev's credits (6)")
		println("See my profile (7)")
		println("Exit (8)")
		op = readLine()!!.toInt()

		when (op) {
			1 -> managerService.createProject(managerUser)
			2 -> managerService.deleteProject(managerUser)
			3 -> managerService.createDev(managerUser)
			4 -> managerService.deleteDev(managerUser)
			5 -> managerService.changeOwnCredits(managerUser)
			6 -> managerService.changeDevsCredits(managerUser)
			7 -> managerUser.returnProfile()
		}

	}


}



