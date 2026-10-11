# spring-boot-multi-module-template
스프링 부트 멀티모듈 템플릿 프로젝트

공통 빌드 설정은 별도 included build인 `build-logic`의 convention plugin으로 관리합니다.
의존성 버전은 `gradle/libs.versions.toml`에서 관리하며, convention plugin에서는
`VersionCatalogsExtension` 공개 API로 적용 대상 프로젝트의 카탈로그에 접근합니다.
저장소는 루트와 `build-logic`의 `settings.gradle.kts`에서 각각 선언합니다.
모듈이나 convention plugin에 저장소를 추가하면 빌드가 실패하므로 설정 파일에 추가하세요.
