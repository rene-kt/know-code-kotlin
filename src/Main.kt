import models.ManagerUser
import java.util.*
import models.DevUser
import models.Project

fun main() {


	val project: Project = Project("Know-Code", "Kotlin")
	val project2: Project = Project("TotalCross", "Java")


	val devUser1: DevUser = DevUser(1, "teste", 1, ManagerUser(), arrayOf(project, project2));
	val devUser2: DevUser = DevUser(2, "teste 2 ", 2, ManagerUser(), arrayOf(project));

	val devs = arrayOf(devUser1, devUser2);


	val managerUser: ManagerUser = ManagerUser(1, "Manager", 10, devs, arrayOf(project))

	for (i in 0..managerUser.devs.size - 1) {
		println("Name of dev [$i] is: " + managerUser.devs.get(i).name)

		println("Their projects are: ")

		for (j in 0..managerUser.devs.get(i).projects.size - 1) {
			println(managerUser.devs.get(i).projects.get(j).name + "||" + managerUser.devs.get(i).projects.get(j).language)

			
		}
		println("----------------------")
	}


}	