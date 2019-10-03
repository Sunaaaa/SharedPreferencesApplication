## SharedPrefereces

- 사용자가 로그인을 성공하면, 사용자에 대한 데이터를 저장하고, 저장된 데이터를 불러서 사용한다.
- Activity 전환 시마다 사용자의 데이터를 전달할 필요가 없다. 
- 간단한 값 저장에 DB를 사용하기에는 복잡하기 때문에 SharedPreferences를 사용하면 적합하다.
- 보통 초기 설정값이나 자동 로그인 여부 등 간단한 값을 저장하기 위해 사용한다.
- 어플리케이션에 파일 형태로 데이터를 저장한다.
  - data/data/패키지명/shared_prefs/[SharedPreference이름].xml 의 위치에 저장된다.
- 어플리케이션이 삭제되기 전까지 저장된다. 

- SharedPreferences를 import해 사용한다.

  ```java
  import android.content.SharedPreferences;
  ```

  

<br><br>

### 사용자 정보 저장

- SharedPreferences를 파일 이름, 기본모드로 설정한다.

  ```java
  SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
  ```

  <br>

  - getPreferences( int mode ) 
    - 하나의 Activity에서만 사용하는 SharedPreferences를 생성한다.
    - 생성되는 SharedPreferences 파일은 해당 Activity 이름으로 생성된다.
    - 하나의 Activity에서만 사용할 수 있지만, getSharedPreferences() 를 사용하면 다른 Activity에서도 사용 가능하다.

  <br>

  - getPreferences( String filename, int mode ) 

    - 특정 이름 ( filename )을 가진 SharedPreferences를 생성한다.

    - 전체 어플리케이션에서 사용한다.

  <br>

- 사용자 정보를 저장하기 위해 Editor를 생성한다.

  ```
  SharedPreferences.Editor editor = preferences.edit();
  ```

  <br>

- 사용자 정보를 "key"-"value" 쌍으로 저장한다.

  ```
  editor.putString("id", userid);
  editor.putString("pw", userpw);
  ```

  <br>

- 커밋하여 최종 저장을 완료한다.

  ```
  editor.commit();
  ```

  <br>

- 저장할 수 있는 데이터 타입
  - Boolean
  - Integer
  - Float
  - Long
  - String

<br>

### 사용자 정보 가져오기

- SharedPreferences를 파일 이름, 기본모드로 설정한다.

  ```java
  SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
  ```

  <br>

- 저장 시 설정한 "key" 를 이용해 해당 "key"에 대한 사용자 정보를 가져온다. 만약, 아무값도 들어있지 않으면 "NO"를 반환한다.

  - 첫번 째 인자로 가져올 데이터의 "key"를 제공한다.

  - 두번 째 인자로 가져올 데이터의 "key"에 값이 없을 경우 반환할 값을 넣어준다.

    ```java
    String a = preferences.getString("id", "NO");
    ```

  <br>



### 사용자 정보 삭제하기

- SharedPreferences를 파일 이름, 기본모드로 설정한다.

  ```java
  SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
  ```

  <br>

- 사용자 정보를 삭제하기 위해 Editor를 생성한다.

  ```
  SharedPreferences.Editor editor = preferences.edit();
  ```

  <br>

  - 특정 사용자 정보 삭제

    - 주어진 "key"에 대한 사용자 정보를 삭제한다.

      ```java
      editor.remove("id");
      ```

    <br>

  - 모든 사용자 정보 삭제

    ```java
    editor.clear();
    ```

    <br>

- 커밋하여 최종 삭제를 완료한다.

  ```
  editor.commit();
  ```

  <br>

### 객체 저장하기

- build.gradle ( Module:app )에 gson 라이브러리를 추가한다.

  ```
  implementation 'com.google.code.gson:gson:2.3.1'
  ```

  <br>

  - 화면

    ![1570077454159](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\1570077454159.png)

    <br>

- SharedPreferences를 파일 이름, 기본모드로 설정한다.

  ```java
  SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
  ```

  <br>

- 객체를 저장하기 위해 Editor를 생성한다.

  ```
  SharedPreferences.Editor editor = preferences.edit();
  ```

  <br>

- Gson을 이용해 객체를 Json으로 변환한다.

  ```java
  Gson gson = new Gson();
  String json = gson.toJson(vo);
  ```

  <br>

- Json으로 변환한 객체를 "key"-"value" 쌍으로 저장한다.

  ```
  editor.putString("vo", json);
  ```

  <br>

- 커밋하여 최종 저장을 완료한다.

  ```
  editor.commit();
  ```

  <br>



### 저장한 객체 가져오기

- SharedPreferences를 파일 이름, 기본모드로 설정한다.

  ```java
  SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
  ```

  <br>

- 저장 시 설정한 "key" 를 이용해 해당 "key"에 대한 객체 (Json) 를 가져온다. 만약, 아무값도 들어있지 않으면 "NO"를 반환한다.

  - 첫번 째 인자로 가져올 데이터의 "key"를 제공한다.

  - 두번 째 인자로 가져올 데이터의 "key"에 값이 없을 경우 반환할 값을 넣어준다.

    ```java
    String json = preferences.getString("vo", "");
    ```

  <br>

- Gson을 이용해 Json 데이터를 객체로 변환한다.

  ```java
  Gson gson = new Gson();
  UserVO vo = gson.fromJson(json, UserVO.class);
  ```

  <br>
