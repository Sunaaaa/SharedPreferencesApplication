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



### 사용자 정보 가져오기

- SharedPreferences를 파일 이름, 기본모드로 설정한다.

  ```java
  SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
  ```

  <br>

- 저장 시 설정한 "key" 를 이용해 해당 "key"에 대한 사용자 정보를 가져온다. 만약, 아무값도 들어있지 않으면 "NO"를 반환한다.

  ```java
  preferences.getString("id", "NO")
  ```

  <br>



### 사용자 정보 삭제하기

- 

