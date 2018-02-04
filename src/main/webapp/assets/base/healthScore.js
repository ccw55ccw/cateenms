/**
 * Created by Administrator on 2017/12/20.
 */

var editor;

jQuery(function($) {
    //initiate dataTables plugin
    var myTable =
        $('#dynamic-table')
        //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
            .DataTable({
                bAutoWidth: false,
                "aoColumns": [
                    {"bSortable": false},
                    null, null, null,
                    {"bSortable": false}
                ],
                "aaSorting": [],


                //"bProcessing": true,
                //"bServerSide": true,
                //"sAjaxSource": "http://127.0.0.1/table.php"	,

                //,
                //"sScrollY": "200px",
                //"bPaginate": false,

                //"sScrollX": "100%",
                //"sScrollXInner": "120%",
                //"bScrollCollapse": true,
                //Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
                //you may want to wrap the table inside a "div.dataTables_borderWrap" element

                //"iDisplayLength": 50

            });


    $('.date-picker').datepicker({
        autoclose: true,
        todayHighlight: true
    });

    $('#add-btn').click(function () {
        formState.setState('add');
        formState.changeFormState();
        $('#my-modal').modal({
            keyboard: true
        });
    });

    $('#subbtn').click(function () {
        var data = $('#tform').serializeObject();
        $.post(formState.stateUrl, {
            dataJson:data
        }, function (res) {
            if (res.isSuccess){
                $('#my-modal').modal('hide');
                layer.msg(formState.stateName+'成功');
                setTimeout(function () {
                    window.location.reload();
                }, 1000);

            }
        });
    });


});

var formState = {
    stateName:'',
    stateUrl:'',
    infoGetUrl:'/cms/api/healthScore_get',
    form:$('#tform'),
    opFlag:$('#opFlag'),
    changeFormState:function () {
        var opFlag = $('#opFlag').val();
        if (opFlag === 'check'){
            this.checkState();
        }else if(opFlag === 'edit'){
            this.editState();
        }else if(opFlag === 'add'){
            this.addState();
        }
    },
    checkState:function () {
        $('#exampleModalLabel').html('查看卫生评分信息');
        $('#formFooter').hide();
        this.stateName = '查看';
    },
    editState:function () {
        $('#exampleModalLabel').html('修改卫生评分信息');
        $('#formFooter').show();
        this.stateName = '编辑';
        this.stateUrl = '/cms/api/healthScore_update';
    },
    addState:function () {
        $('#exampleModalLabel').html('新增卫生评分信息');
        $('#formFooter').show();
        this.stateName = '新增';
        this.stateUrl = '/cms/api/healthScore_add';
        $('#title').val('');
        $('#score').val('');
        $('#scoreTime').val('');
        $('#id').val('');
    },
    setState:function (state) {
        this.opFlag.val(state);
    }
};


function getInfo(data) {
    $.post(formState.infoGetUrl, {dataJson: JSON.stringify(data)}, function (res) {
        if (res.isSuccess) {
            $('#title').val(res.healthScore.title);
            $('#score').val(res.healthScore.score);
            $('#id').val(res.healthScore.id);

            $('#scoreTime').datepicker('setDate', res.healthScore.scoreTime.substr(0,10));

            $('#my-modal').modal({
                keyboard: true
            });
        }
    });
}
function editForm(id) {
    formState.setState('edit');
    formState.changeFormState();
    var data = {
        id:id
    };
    getInfo(data);
}


function seeForm(id) {
    formState.setState('check');
    formState.changeFormState();
    var data = {
        id:id
    };
    getInfo(data);
}

function doDelete(id) {
    //询问框
    layer.confirm('确定删除吗？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var data = {
            id:id
        };
        $.post('/cms/api/healthScore_delete', {dataJson: JSON.stringify(data)}, function (res) {
            console.info(res);
            if (res.isSuccess) {
                layer.msg('删除成功');
                setTimeout(function () {
                    window.location.reload();
                }, 1000);
            }
        });
    }, function(){

    });
}

