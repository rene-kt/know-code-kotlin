package models

class Project {
	
	var name: String = ""
	var language: String = ""

	
	constructor(){}
	constructor(name: String, language: String){
		this.name = name
		this.language = language
	}
	
}