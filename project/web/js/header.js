$(function() {
	
/*
	alert($(window).width());
	alert($(window).height());*/
	$(".main_memu li").each(function(i, k) {

	
		$(k).mouseenter(function() {
			$(".sub_menu ul").css("display", "none");
			$(".sub_menu ul").eq(i).css("display", "block");
		});

		$(".sub_menu").mouseleave(function() {
			$(".sub_menu ul").eq(i).css("display", "none");
		});

	});

});
