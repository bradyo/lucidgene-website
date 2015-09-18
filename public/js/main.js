// hide content until cover images loaded using overlay
$(window).load(function() {
    $("#loading-overlay").fadeOut("fast");
});
$("#loading-overlay").click(function() {
    $("#loading-overlay").fadeOut("fast");
});

// fade in loading image after 200ms to avoid un-necessary loading image
window.setInterval(
    function () {
        $("#loading-image").fadeIn("slow")
    },
    200
);

// bind deferred image loading event
$("img.deferred").lazyload({
    event : "load-images",
    effect : "fadeIn"
});
$(window).load(function() {
    $("img.deferred").trigger("load-images");
});
