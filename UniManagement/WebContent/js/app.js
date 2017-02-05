$(document).ready(function() {

	//Stops the submit request
	$("#myAjaxRequestForm").submit(function(e){
		e.preventDefault();
	});

	//checks for the button click event
	$("#semDrop").change(function(e){
		//get the form data using another method 
		var semId = $('#semDrop option:selected').val();
		var queryStr = '?action=courses&semId=' + semId;

		//make the AJAX request, dataType is set to json
		//meaning we are expecting JSON data in response from the server
		$.ajax({
			type: "GET",
			url: "enrollment.do" + queryStr,


			//if received a response from the server
			success: function( data, textStatus, jqXHR) {
				//our country code was correct so we have some information to display
				var obj = JSON.parse(data);
				if(obj.success){
					$('#tableData').empty();
					var str='';
					console.log(obj);
					obj.courseData.forEach( function( item ) {
						str += '<tr>'
							str +='<td>'+item.courseName+'</td>'; 
						str +='<td>'+item.facultyName+'</td>';
						str +='<td>'+item.startDate+'</td>';
						str +='<td>'+item.endDate+'</td>';
						str +='<td>'+item.capacity+'</td>';
						if(item.isEnrolled){
							str +='<td> Enrolled </td>';
						}else{
							str +='<td><a  class="btn btn-success" href="enrollment.do?action=enroll&courseId=' + item.courseId + '"> Enroll</a></td>';

						}
						str +='</tr>';

					});
					$('#tableData').append(str);
					document.getElementById('tableDiv').style.display = "block";
					document.getElementById('errorDiv').style.display = "none";



				} 
				//display error message
				else {
					$("#errorDiv").html("<div><b> No courses in this Semester.</b></div>");
					document.getElementById('errorDiv').style.display = "block";
					document.getElementById('tableDiv').style.display = "none";

				}
			}



		});        
	});

});