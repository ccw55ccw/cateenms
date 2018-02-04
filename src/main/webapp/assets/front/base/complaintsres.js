/**
 * Created by Administrator on 2018/1/27.
 */

$(function(){


});

function seeResult(id) {

    var data = {
        id:id
    };
    $.post('/cms/api/complaints_get', {dataJson: JSON.stringify(data)}, function (res) {
        console.info(res.complaints.result);
        if (res.isSuccess) {
            if(res.complaints.state === '1'){
                layer.alert(res.complaints.result, {
                    title:'处理结果'
                });
            }else {
                layer.msg('暂无处理结果');
            }
        }
    });
}
