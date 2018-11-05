/**
 * 
 */
$(function() {

	$('.menuicon .glyphicon-menu-hamburger').click(function(e) {
		e.preventDefault();
		var navActive = $('.rwd-nav').hasClass('rwd-nav-active');
		if(navActive) {
			$('.rwd-nav').addClass('rwd-nav-unactive');
		}
		$('.menu_container').toggleClass('menu_container-active');
		var flag = $('.menu_container').hasClass('menu_container-unactive');
		$('.menu_container').removeClass('menu_container-unactive');
		if(flag) {
			$('.menu_container').addClass('menu_container-active');
		}
	});
	
	$('.aggs').click(function(e){
		e.preventDefault();
		var menuActive = $('.menu_container').hasClass('menu_container-active');
		if(menuActive) {
			$('.menu_container').addClass('menu_container-unactive');
		}
		$('.rwd-nav').toggleClass('rwd-nav-active');
		var flag = $('.rwd-nav').hasClass('rwd-nav-unactive');
		$('.rwd-nav').removeClass('rwd-nav-unactive');
		if(flag) {
			$('.rwd-nav').addClass('rwd-nav-active');
		}
	});
	
	$('.menu').click(function() {
		alert(111);
	});
});
