$(function(){
    //상태객체
    var state = {
        countryNameValid : false,
        countryRegionValid : false, 
        countryCapitalValid : false, 
        countryPopulationValid : false,
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

    //개별입력창검사
    // document.querySelector("[name=countryRegion]")
    $("[name=countryRegion]").on("input", function(){
        var regex = /^(아시아|아프리카|[남북]아메리카|유럽|오세아니아)$/;
        // var valid = regex.test(this.value);
        var valid = regex.test($(this).val());
        // this.classList.remove("success", "fail");
        // this.classList.add(valid ? "success" : "fail");
        $(this).removeClass("success fail").addClass(valid? "success": "fail");

        state.countryRegionValid = valid;//외부 state에 보관
    });
    $("[name=countryName]").on("blur", function(){
        var regex = /^[가-힣]{1,10}$/;
        // var valid = regex.test(this.value);
        var valid = regex.test($(this).val());

        // this.classList.remove("success", "fail");
        // this.classList.add(valid? "success": "fail");
        $(this).removeClass("success fail").addClass(valid? "success": "fail");
        //return valid; //구조적으로 쓸 수 없는 의미없는 코드 //콜백때매 다 바뀌는 거거든요. 
        state.countryNameValid = valid;//state에보관 
    });
    $("[name=countryCapital]").on("blur", function(){
        var valid = $(this).val().length > 0;
        // this.classList.remove("success", "fail");
        // this.classList.add(valid? "success": "fail");
        $(this).removeClass("success fail").addClass(valid? "success": "fail");
        state.countryCapitalValid = valid;//state에 보관
    });

    $("[name=countryPopulation]").on("blur", function(){
        var value = $(this).val();
        var valid = value.lenth > 0 && parseInt(value) > 0;
        // this.classList.remove("success", "fail");
        // this.classList.add(valid? "success": "fail");
        $(this).removeClass("success fail").addClass(valid? "success": "fail");
        state.countryPopulationValid = valid;
    });
    //숫자 입력창 처리
    //반복문 없이 한번에 처리 jQuery니까
    $("[inputmode=numeric]").on("input", function(){
        var regex = /[^0-9]+/g;
        var replacement = $(this).val().replace(regex, "");
        $(this).val(replacement);
    });
    //폼검사
    $(".form-check").on("submit", function(){
        //화면처리(이벤트 트리거)
        $(this).find("select[name]").trigger("input");
        $(this).find("input[name], textarea[name]").trigger("blur");

        return state.ok();
    });

});