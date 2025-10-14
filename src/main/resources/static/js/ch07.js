let a = 1;
        let b = "자바스크립트";

        typeof a;
        typeof b;

        const PI = 3.14;

        console.log(a);
        console.log(b);
        console.log(PI);

        alert("PI: " + PI);

        if (a === 1) {
            console.log("a=1");
        } else {
            console.log("a는 1이 아님");
        }

        // ----------------------

        const arr = [];
        arr.push(10);
        arr.push(20);
        arr.push(30);

        console.log(arr);
        console.log(arr[2]);
        console.log(arr.length);

        arr.splice(1, 1);
        console.log(arr);

        // ----------------------

        const arr2 = [1, 2, 3, 4, 5];

        for (let i = 0; i < arr2.length; i++) {
            console.log(arr2[i]);
        }

        // ----------------------

        function addTwo(one, two) {
            return one + two;
        }

        let result = addTwo(3, 5);
        console.log(result);

        // ----------------------

        const minusTwo = (one, two) => {
            return one - two;
        }
        let result2 = minusTwo(5, 3);
        console.log(result2);

        // ---------------------- 

        const wrapperFunc = (minusTwo) => {
            const result3 = minusTwo(20, 10);
            console.log(result3);
        }
        wrapperFunc(minusTwo);

        const returnFunc = () => {
            return addTwo;
        }
        const result4 = returnFunc()(15, 35);
        console.log(result4);

        // ----------------------

        const ajaxRequest = new XMLHttpRequest();

        function onReadyStateChange(event) {
            if(ajaxRequest.readyState === XMLHttpRequest.DONE) {
                if(ajaxRequest.status === 200) {
                    console.log(ajaxRequest.responseText);
                } else {
                    console.error("request failed");
                }
            }
        }

        ajaxRequest.onreadystatechange = onReadyStateChange;
        ajaxRequest.open('GET', '/get-with-no-parameter');
        ajaxRequest.send();

        // ----------------------

        

