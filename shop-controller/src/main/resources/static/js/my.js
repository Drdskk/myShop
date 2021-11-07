function check_login() {
    var inputName = $("#user_name").val();
    var inputPassword = $("#password").val();
    if(inputName == '' || inputName == null) {
        alert("请输入用户名！");
        $("#login_form").removeClass('shake_effect');
        setTimeout(function() {
            $("#login_form").addClass('shake_effect')
        }, 1);
        return false;
    }
    if(inputPassword == '' || inputPassword == null) {
        alert("请输入密码！");
        $("#login_form").removeClass('shake_effect');
        setTimeout(function() {
            $("#login_form").addClass('shake_effect')
        }, 1);
        return false;
    }
    $.ajax({
        url:"/user/getUser",
        type:"POST",
        data:$("#loginForm").serialize(),
        success:function (result) {
            if(result == 1){
                alert("登录成功！");
                $("#user_name").val("");
                $("#password").val("");
                window.location.href="/user/head";
            }else {
                alert("用户名或密码错误")
                alert(result.extendInfo.login_error);
                $("#login_form").removeClass('shake_effect');
                setTimeout(function() {
                    $("#login_form").addClass('shake_effect')
                }, 1);
            }
        }

    });
}



function check_userAdd() {
    $.ajax({
        url:"/user/addUser",
        type:"POST",
        data:$("#userAddForm").serialize(),
        success:function (result) {
            if(result == 1){
                alert("操作成功");
                window.location.href="getUsers";
            }else {
                alert("操作失败");
            }
        }
    });
}


function check_addressAdd() {
    $.ajax({
        url:"/address/addAddress",
        type:"POST",
        data:$("#addressAddForm").serialize(),
        success:function (result) {
            if(result == 1){
                alert("操作成功");
                window.location.href="getAddress";
            }else {
                alert("操作失败");
            }
        }
    });
}


function check_goodsAdd() {
    $.ajax({
        url:"/goods/addGoods",
        type:"POST",
        data:$("#goodsAddForm").serialize(),
        success:function (result) {
            if(result == 1){
                alert("操作成功");
                window.location.href="getGoods";
            }else {
                alert("操作失败");
            }
        }
    });
}

function check_goodsPicAdd() {
    var form = new FormData(document.getElementById("goodsPicAddForm"));
    $.ajax({
        url:"/goods/picUpload",
        type:"POST",
        data:form,
        processData:false,
        contentType:false,
        success:function (result) {
            if(result == 1){
                alert("操作成功");
                window.location.href="getGoods";
            }else {
                alert("操作失败");
            }
        }
    });
}


function check_bigTypeAdd() {
    $.ajax({
        url:"/bigType/addBigType",
        type:"POST",
        data:$("#bigTypeAddForm").serialize(),
        success:function (result) {
            if(result == 1){
                alert("操作成功");
                window.location.href="getBigTypes";
            }else {
                alert("操作失败");
            }
        }
    });
}


function check_smallTypeAdd() {
    $.ajax({
        url:"/smallType/addSmallType",
        type:"POST",
        data:$("#smallTypeAddForm").serialize(),
        success:function (result) {
            if(result == 1){
                alert("操作成功");
                window.location.href="getSmallTypes";
            }else {
                alert("操作失败");
            }
        }
    });
}

function check_shopCarAdd() {
    $.ajax({
        url:"/shopCar/addShopCar",
        type:"POST",
        data:$("#shopCarAddForm").serialize(),
        success:function (result) {
            if(result == 1){
                alert("操作成功");
                window.location.href="getShopCars";
            }else {
                alert("操作失败");
            }
        }
    });
}

function check_ordAdd() {
    $.ajax({
        url:"/ord/addOrd",
        type:"POST",
        data:$("#ordAddForm").serialize(),
        success:function (result) {
            if(result == 1){
                alert("操作成功");
                window.location.href="getOrds";
            }else {
                alert("操作失败");
            }
        }
    });
}

$(function() {
    $("#login").click(function() {
        check_login();
        return false;
    })
    $("#userAdd").click(function() {
        check_userAdd();
        return false;
    })
    $("#addressAdd").click(function() {
        check_addressAdd();
        return false;
    })
    $("#goodsAdd").click(function() {
        check_goodsAdd();
        return false;
    })
    $("#goodsPicAdd").click(function() {
        check_goodsPicAdd();
        return false;
    })
    $("#bigTypeAdd").click(function() {
        check_bigTypeAdd();
        return false;
    })
    $("#smallTypeAdd").click(function() {
        check_smallTypeAdd();
        return false;
    })
    $("#shopCarAdd").click(function() {
        check_shopCarAdd();
        return false;
    })
    $("#ordAdd").click(function() {
        check_ordAdd();
        return false;
    })
    $('.message a').click(function() {
        $('form').animate({
            height : 'toggle',
            opacity : 'toggle'
        }, 'slow');
    });
})


/*function check_register() {
    var inputName = $("#r_user_name").val();
    var inputPassword = $("#r_password").val();
    var inputNewPassword = $("#r_newpassword").val();
    if(inputName == '' || inputName == null) {
        alert("请输入用户名！");
        $("#login_form").removeClass('shake_effect');
        setTimeout(function() {
            $("#login_form").addClass('shake_effect')
        }, 1);
        return false;
    }
    if(inputPassword == '' || inputPassword == null) {
        alert("请输入密码！");
        $("#login_form").removeClass('shake_effect');
        setTimeout(function() {
            $("#login_form").addClass('shake_effect')
        }, 1);
        return false;
    }
    if(inputPassword != inputNewPassword) {
        alert("输入的两次密码不同，请重新输入！");
        $("#login_form").removeClass('shake_effect');
        setTimeout(function() {
            $("#login_form").addClass('shake_effect')
        }, 1);
        return false;
    }
    $.ajax({
        url:"/user/addUser",
        type:"POST",
        data:$("#registerForm").serialize(),
        success:function (result) {
            if(result.code == 100){
                alert("注册失败");
                window.location.href="login.html";
            }else {
                alert("账户已存在");
                alert(result.extendInfo.register_error);
            }
        }
    });
}*/
/*
$("#create").click(function() {
    check_register();
    return false;
})*/
