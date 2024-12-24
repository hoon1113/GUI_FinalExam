# 기숙사 건의사항 및 고장 신고 앱

----

## 개요

### 목적

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

여기서 궁금한 것은 __이스터에그__ 일 것이다.

이것은 심심풀이로 갑자기 생각나서 추가한 것인데, 설명하지 않을려고 했지만 컬렉션 프레임워크를 사용했기 때문에 설명한다.

건의사항에 "one above all" 이라고 입력하고 등록버튼을 누르면 csv파일의 내역을 볼 수 있다.

이것은 기숙사의 학생 정보를 볼 수 있는 무서운 장난(?) 같은 기능이다.

## 클래스 다이어그램

![Class_Diagram](https://github.com/hoon1113/GUI_FinalExam/blob/main/Class_Diagram.jpg)

위에는 클래스 단위로 구분된 프로그램이 클래스끼리 어떻게 영향을 주는지 보여주는 다이어그램이다.
#### FinalExam.java
- 메인 클래스는 FinalExam.java이다.
- 프로그램이 실행되는 클래스이다.
- 이곳은 크게 RockPanel이랑 MainPanel로 나뉘며 처음에 RockPanel이 보여지고 로그인에 성공하면 cardLayout에 의해 MainPanel로 넘어간다.
- 해쉬멥을 이용해 csv의 정보를 저장한다.
#### RockPanel.java
- RockPanel은 말그대로 처음 보여지는 잠금화면이다. 학번과 비밀번호를 치고 로그인 버튼을 누르면 MainPanel로 넘어간다.
- 로그인 버튼은 엔터키를 입력해도 클릭 될 수 있게 편의성을 고려해 만들었다.
- HashMap에 저장된 정보와 사용자가 입력한 정보가 일치 하지 않으면 로그인 정보가 일치 하지 않다고 오류 메시지를 표시한다.
- 배경은 청주대 사진을 넣어봤다. ~~(중요한 것은 아니다.)~~
#### MainPanel.java
- MainPanel은 로그인이 성공했을때 나오는 화면이다. 이 패널을 BorderLayout으로 구성되어 있고 각 패널 또한 각자의 클래스로 구분되어있다.
- 각자 NorthPanel, CenterPanel, WestPanel로 구분되어있으며 이 클래스들 또한 차차 설명 할 것이다.
#### NorthPanel.java
- MainPanel의 가장 위쪽의 패널이다.
- 청주대학교 로고와 이름, 수리 및 신고 시스템이라고 쓰여있다.
- 이 프로그램의 목적이 뭔지 함축적으로 담고 있다.
#### CenterPanel.java
- CardLayout을 이용해 두개의 패널을 이동해 보여준다. RecordPanel, HomePanel 두개를 보여주고 있다.
#### HomePanel.java
- 아마 여기 클래스 중에서 프로그램 목적에 가장 근접한 클래스 라고해도 과언이 아니다.
- 첫번째 콤보박스에 선택에 따라 두번째 콤보박스의 내용이 달라진다. (그 장소에 맞는 물품들이 보여진다.)
- 이렇게 두개의 콤보박스를 이용해 간단히 수리 항목을 선택 할 수 있다.
- 만약 콤보박스로도 부족하다고 느끼거나 다른 건의 사항이 있을때는 그 밑의 TextArea를 이용해 하고 싶은 말을 적으면 된다.
- 이렇게 하고 싶은 말을 다 적고 등록 버튼을 누르면 밑에 레이블이 생기면서 자신이 쓴 수리내용, 건의사항이 보여진다.
- 그리고 그 보여진 레이블과 같은 내용이 좌측 기록버튼을 통해 이동 할 수 있는 기록실에 순서대로 보관된다. (RecordPanel.java가 영향을 받는다는 뜻)
- 이곳에는 HashMap을 이용해 이스터에그를 넣어놨다.
  - 만약 TextArea에 "one above all" 이라고 적고 등록버튼을 누르면 하단에 csv자료가 나온다.
  - csv에는 학번, 비밀번호, 이름이 적혀있다. ~~(악용하지 말자)~~
#### RecordPanel.java
- HomePanel에서 입력된 정보가 기록되는 곳이다.
- HomePanel에서 등록버튼을 누르면 바로 순번과 같이 중앙에 레이블로 찍힌다.
- 코드 중에 .revalidate(); 라는 코드가 있는데 이것이 실시간으로 UI을 갱신하기 때문에 등록버튼을 누르면 바로바로 기록이 남겨지게 된다.
#### WestPanel.java
- CenterPanel에서 보여질 패널들로 이동 할 수 있게 해주는 역할이다.
- 버튼2개가 있으며 각 이름에 맞게 홈 버튼은 수리 및 신고를 할 수 있는 패널로 이동 할 수 있고, 기록버튼은 등록버튼을 눌렀을때 찍히는 값을 기록해두는 곳이다. (즉 이 버튼으로 CenterPanel이 영향을 받음)
- 버튼에 태두리와 누를때 모션을 없애서 깔끔하게 만들었다.

## 실행 이미지
![처음화면](https://github.com/hoon1113/GUI_FinalExam/blob/main/FirstPanel.jpg)

처음 실행하면 나오는 화면이다. (로그인 기능이 있다.)

![로그인후화면](https://github.com/hoon1113/GUI_FinalExam/blob/main/HomePanel.jpg)

로그인에 성공하면 나오는 화면이다. (여기서 목적에 맞는 활동을 할 수 있다.)

![기록화면](https://github.com/hoon1113/GUI_FinalExam/blob/main/RecordPanel.jpg)

등록버튼을 누르면 찍히는 화면이다. (여태 내가 어떤 항목을 등록했는지 볼 수 있다.)

## 느낀점

중간고사를 통해서는 GUI의 디자인 방법, 움직임에 대해 배웠다면 이번 기말고사에서는 확실히 자바의 고급 기능들을 사용하는 법을 배웠다.

컬렉션을 사용하면서 좀 더 고급기능을 구현 할 수 있게 되었고, 무엇보다 클래스 구분의 중요성을 알게 되었다.

클래스를 구분하면서 확실히 코딩하기 편했고 각 구역별 기능을 한눈에 알기 쉬웠다. 만약 구분하지 않았다면 스크롤을 한참 내리면서 찾았을거다.

그리고 다이어그램을 통해 좀 더 채게적이고 구체적으로 설계를 했기 때문에 코딩할 때 편했다. 하지만 단점이라면 중간에 클래스들끼리 연결점이 많은데 만약 중간에 바꿔야 하는 일이 생기면 다이어그램이 꼬여버려 좀 난감했다. 이런 현상은 아직 내가 익숙하지 않아서 생기는 문제라고 생각한다.

이제 자바를 이용해 그 무엇도 만들 수 있을것 같다. 이 프로젝트를 하면서 학교에서 배운 내용 뿐만 아니라 구현 하기위해 구굴링한 문법이나 방법들이 많기 때문에 많은 공부가 되었다.

중간 기말을 거치면서 확실히 코딩은 손으로 직접 하면서 내가 무언가를 만들어가면서 배우는게 가장 빠르고 정확하게 공부된다는것을 알았다.
앞으로 다른 언어를 공부 하더라도 내가 직접 무언가를 만들어가며 공부할 것 같다.
