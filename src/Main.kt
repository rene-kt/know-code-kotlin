import models.ManagerUser
import java.util.*
import models.DevUser

fun main(){
	
	val devUser1: DevUser = DevUser(1, "teste", 1, ManagerUser());
	val devUser2: DevUser = DevUser(2, "teste 2 ", 2, ManagerUser());
	
	val devs = arrayOf(devUser1, devUser2);
	
	
	val managerUser: ManagerUser = ManagerUser(1, "Manager", 10, devs)
	
	for(i in 0..managerUser.devs.size - 1){
		println("Name of dev [$i] is: " + managerUser.devs.get(i).name)
	}
	
	
}	