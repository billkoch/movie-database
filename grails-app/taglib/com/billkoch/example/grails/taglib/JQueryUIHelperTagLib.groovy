package com.billkoch.example.grails.taglib

class JQueryUIHelperTagLib {

	static namespace = 'koch'

	def jqDatePicker = { attrs, body ->
		def variableName = attrs.variableName
		def date = attrs.date
		
		out << render(template:"/common/jqueryUIDatePickerTemplate", model:[date:attrs.date, variableName:attrs.variableName])
	}
}
