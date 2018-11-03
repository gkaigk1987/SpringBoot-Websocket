/**
 * 
 */
$(function() {

	$('.menuicon').click(function(e) {
//		alert(2121);
		e.preventDefault();
		$('.menu_container_1').toggleClass('menu_container_1-activ');
	});
	$('.menu').click(function() {
		alert(111);
	});
});
