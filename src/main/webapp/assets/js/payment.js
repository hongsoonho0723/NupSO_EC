var IMP = window.IMP;
IMP.init("imp58685680");

const buyButton = document.getElementById('payment');
buyButton.addEventListener('click', function() {
    const user_email = "hong@gmail.com";
    const username = "hong";

    if (confirm("구매 하시겠습니까?")) {
        if (localStorage.getItem("access")) {
            const emoticonName = document.getElementById('title').innerText;
            const amount = 100; // 가격을 하드코딩 대신 동적으로 설정

            var today = new Date();
            var hours = today.getHours();
            var minutes = today.getMinutes();
            var seconds = today.getSeconds();
            var milliseconds = today.getMilliseconds();
            var makeMerchantUid = `${hours}${minutes}${seconds}${milliseconds}`;

            IMP.request_pay({
                pg: 'kakaopay.TC0ONETIME',
                pay_method: 'card',
                merchant_uid: "IMP" + makeMerchantUid,
                name: emoticonName,
                amount: amount,
                buyer_email: user_email,
                buyer_name: username,
            }, async function (rsp) {
                if (rsp.success) {
                    console.log(rsp);
                    // 결제 성공 시 로직
                    if (response.status == 200) {
                        alert('결제 완료!');
                        window.location.reload();
                    } else {
                        alert(`error:[${response.status}]\n결제요청이 승인된 경우 관리자에게 문의바랍니다.`);
                    }
                } else {
                    // 결제 실패 시 로직
                    alert(rsp.error_msg);
                }
            });
        } else {
            alert('로그인이 필요합니다!');
        }
    } else {
        return false;
    }
});
