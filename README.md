# 기숙사 건의사항 및 고장 신고 앱

----


## 개요


#### 목적

기숙사 생활을 하면서 고장이나 건의를 좀 더 쉽고 간편하게 할 수 있게 하기 위해 만들었다.

### 대상

기숙사를 이용하고 있는 청주대 학생

## 프로그램의 중요성 및 필요성

### 중요성

기숙사를 생활하면서 갑작스러운 시설 고장이나 입실 전 부터 망가져 있었던 시설을 빠르게 고쳐야 생활에 불편함이 없다.

### 필요성

직접 사관과 마주치지 않고 건의를 넣을 수 있으며 사관 또한 정형화 되어있는 문장으로 쉽게 고장난 곳이 어딘지 파악 할 수 있다.

## 프로그램 수행 절차

![Program_Diagram](https://github.com/hoon1113/GUI_FinalExam/blob/main/Program_Diagram.jpg)

전체적인 흐름은 위의 사진과 같다.

1. csv파일을 먼저 준비한다.
2. csv파일의 내용을 HashMap에 저장한다.
3. 프로그램을 실행한다.
4. 프로그램에 학번, 비밀번호를 입력한다.
5. 만약 학번, 비밀번호가 HashMap에 저장한 값과 일치하면 로그인 성공 (아니면 실패 문구가 뜨면서 못 들어감)
6. 로그인에 성공했다면 건의하고 싶은 사항을 콤보박스를 통해 선택한다.
7. 추가적으로 해야할말이 있다면 밑에 건의사항 텍스트에리어를 이용한다.
8. 마지막으로 등록 버튼을 눌러 잘 출력되었는지 하단에 생기는 레이블로 확인한다.
9. 만약 이전 기록을 보고 싶다면 좌측의 기록 버튼을 눌러 확인한다.

여기서 궁금한 것은 이스터에그 일것 이다.

이것은 심심풀이로 갑자기 생각나서 추가한 것인데, 설명하지 않을려고 했지만 컬렉션 프레임워크를 사용했기 때문에 설명한다.

건의사항에 "one above all"이라고 입력하고 등록버튼을 누르면 csv파일의 내역을 볼 수 있다.

이것은 기숙사의 학생 정보를 볼 수 있는 무서운 장난(?) 같은 기능이다.

## 클래스 다이어그램

![Class_Diagram]()
