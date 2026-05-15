//강좌 등록화면 검사코드

$(function(){
    //상태객체
    var state = {
        lectureTitleValid : false,
        lectureCategotyValid : false,
        lectureDurationValid : false,
        lecturePriceValid : false,
        lectureTypeValid : false,
        ok : function(){
            return Object.values(this)//이 객체의 모든 이름에 대한 값을 반환해라. (람다)
                .filter(v => typeof v === "boolean")//boolean값만 추출해서 
                // .filter(function(v)){
                //     return typeof v == "boolean"
                // })
                .every(v => v === true); //모두 true인지 확인해서 반환해라! 
                // .every(function(v){
                //     return v === true;
                // })
        }
    };
    //개별항목
    $("[name=lectureTitle]").on("blur", function(){
        var valid = $(this).val().length > 0;
        $(this).removeClass("success fail").addClass(valid? "success": "fail");

        state.lectureTitleValid = valid;
    });
    $("[name=lectureCategory]").on("input", function(){
        var regex = /^(이론|실습|시험)$/;
        var valid = regex.test($(this).val());
        $(this).removeClass("success fail").addClass(valid? "success": "fail");

        state.lectureCategotyValid = valid;
    });
    $("[name=lectureDuration]").on("blur", function(){
        var value = $(this).val();
        var duration = parseInt(value);
        var valid = duration <= 300 && duration >0;
        $(this).removeClass("success fail").addClass(valid? "success": "fail");

        state.lectureDurationValid = valid;
    });
    $("[name=lecturePrice]").on("blur", function(){
        var value = $(this).val();
        var price = parseInt(value);
        var valid = price > 0 && price <= 10000000000;
        $(this).removeClass("success fail").addClass(valid? "success": "fail");

        state.lecturePriceValid = valid;
    });
    $("[name=lectureType]").on("input", function(){
        var regex = /^(온라인|오프라인|혼합)$/;
        var valid = regex.test($(this).val());
        $(this).removeClass("success fail").addClass(valid? "success": "fail");

        state.lectureTypeValid = valid;
    });

    //유틸리티
    $("[inputmode=numeric]").on("input", function(){
        var regex = /[^0-9]+/g;
        var replacement = $(this).val().replace(regex, "");
        $(this).val(replacement);
    });

    //폼검사
    $(".form-check").on("submit", function(){
        $(this).find("select[name]").trigger("input");
        $(this).find("input[name], textarea[name]").trigger("blur");

        return state.ok();
    });
});