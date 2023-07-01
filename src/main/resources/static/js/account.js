// 버튼 클릭 이벤트 처리
document.getElementById('signUpButton').addEventListener('click', function() {
    // 회원가입 화면 표시
    document.getElementsByClassName('login-content-signup')[0].classList.remove('ng-hide');
    document.getElementsByClassName('login-content-signin')[0].classList.add('ng-hide');
    document.getElementById("signUpButton").style.display = 'none';
    document.getElementById("signInButton").style.display = 'block';
});

document.getElementById('signInButton').addEventListener('click', function() {
    // 로그인 화면 표시
    document.getElementsByClassName('login-content-signin')[0].classList.remove('ng-hide');
    document.getElementsByClassName('login-content-signup')[0].classList.add('ng-hide');
    document.getElementById("signUpButton").style.display = 'block';
    document.getElementById("signInButton").style.display = 'none';
});