import models.ManagerUser
import models.Project
import models.DevUser
import services.DevUserService

fun main() {

	val devService: DevUserService = DevUserService()
			
	var devLogged: DevUser

	println("Do you wanna log in as a Dev (1) or as a Manager (2)?")
	var op: Int = readLine()!!.toInt();

	if (op == 1) {
		devLogged = devService.createDevUser()
		devPainel(devLogged)
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



