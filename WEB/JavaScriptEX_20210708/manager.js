//회원정보: 아아디,비밀번호,이름
//Member 생성자
function Member(id, pw, name) {
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}

Member.prototype.makeHtml = function () {
    return '[id:' + this.userId + ' , pw: ' + this.pw + ' , name: ' + this.userName + ' ]'
};

//회원정보를 저장하는 배열
var members = [];

window.onload = function() {

    //localStorage에 저장되어 있는 값이 존재하는지 아닌지 확인
    if (localStorage.getItem('members') == null) {
        localStorage.setItem('members', JSON.stringify(members));
    } else {
        members = JSON.parse(localStorage.getItem('members'));
        console.log(members);

        setList1();
    }


    // 사용자의 입력값
    var userid = document.querySelector('#userID');
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var username = document.querySelector('#userName');

    // regForm을 캐스팅 해준다는데 왜 굳이 해줘야 하나?
    var regForm = document.getElementById('regForm');

    regForm.onsubmit = function() {

        //배열에 사용자 정보 추가
        //왜 .value를 사용해야 하지?
        members.push(new Member(userid.value, pw.value, username.value));

        //localStorage에 저장
        localStorage.setItem('members', JSON.stringify(members));

        //테이블 세팅
        setList1();

        return false; // 입력값이 없으면 되돌아간다는 뜻
    }

    userid.addEventListener('focus', function () {
        document.querySelector('#userID+div.msg').style.display = 'none';
        document.querySelector('#userID+div.msg').innerHTML = '';
        //userid.value='';
    });

    pw.addEventListener('focus', function () {
        document.querySelector('#pw+div.msg').style.display = 'none';
        document.querySelector('#pw+div.msg').innerHTML = '';
    });

    repw.addEventListener('focus', function () {
        document.querySelector('#repw+div.msg').style.display = 'none';
        document.querySelector('#repw+div.msg').innerHTML = '';
        repw.value = '';
    });

    userName.addEventListener('focus', function () {
        document.querySelector('#userName+div.msg').style.display = 'none';
        document.querySelector('#userName+div.msg').innerHTML = '';
    });


}


// 배열에 있는 요소를 table tr행을 만들어서 출력
function setList1() {

    // table의 tbody캐스팅
    var list = document.querySelector('#list');

    var tbody = '<tr>';
    tbody += '<th>순번인덱스</th>'
    tbody += '<th>아이디</th>'
    tbody += '<th>비밀번호</th>'
    tbody += '<th>이름</th>'
    tbody += '<th>관리</th>'
    tbody += '</tr>'

    if (members.length < 1) {

        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존재하지않습니다.</td>';
        tbody += '</tr>';


    } else {

        for (var i = 0; i < members.length; i++) {
            tbody += '<tr>';
            tbody += '  <td>' + i + '</td>';
            tbody += '  <td>' + members[i].userId + '</td>';
            tbody += '  <td>' + members[i].pw + '</td>';
            tbody += '  <td>' + members[i].userName + '</td>';
            tbody += '  <td> <a href="javascript:editMember(' + i + ')">수정</a> | <a href="javascript:deleteMember(' + i + ')">삭제</a></td>';
            tbody += '</tr>';
        }
    }

}