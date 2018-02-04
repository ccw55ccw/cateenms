/**
 * Created by Administrator on 2018/1/27.
 */

$(function(){
    $("#employeeId").change(function () {
        var name = $("#employeeId").find("option:selected").text();
        console.info(name);
        $("#employeeName").val(name);
    });

    $('#subbtn').click(function () {
        var data = $('#tform').serializeObject();
        $.post('/cms/api/complaints_add', {
            dataJson:data
        }, function (res) {
            if (res.isSuccess){
                layer.msg('投诉提交成功');
                setTimeout(function () {
                    window.location.reload();
                }, 1000);

            }
        });
    });

});

