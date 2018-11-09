package com.sbxcloud.testclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;


@SpringBootApplication
public class TestClientApplication {


    private static final String[] keys = {"818fac5a-5040-4cdc-88c5-8e77524709c4",
            "fd1b9a15-7a56-41c2-b53f-cf048ce7ed11",
            "02fb9089-0959-49c9-ab4d-cc17b73638c6",
            "c917ef40-2f13-484e-a32f-d88c212e04d8",
            "4330c8d3-baf5-48e8-aec6-8b3c841b2077",
            "4574cba3-05d4-48ca-9528-346079166fcf",
            "06c5ccd5-6c58-4f91-b9eb-6ad71270b59b",
            "07b7d0a6-a72c-406e-bdc8-df65eca8cea1",
            "083fc0bc-0ed0-47db-a4fd-6e30fbec0931",
            "60a1c8fa-4770-44ac-b420-e66340d647e8",
            "0ae5b8b4-8c80-456d-b041-7c0bcf6ddb6f",
            "84727047-e247-494a-ae86-8b59838f7e42",
            "5124068e-81ca-4a56-ba0e-53f3d65890bd",
            "b8a22c77-412b-4908-a139-d86df2d1a13b",
            "c39d8a15-4770-4533-aa02-1e6bd5f7d045",
            "1a16965a-09a0-447b-9708-517e7f5b1d6a",
            "109687a6-d0b8-4215-bc6b-040f44f093c3",
            "d5516a3f-1123-4055-a48a-50849a3c88ff",
            "14d5639b-5a30-42f5-80b1-5fd02bbb99aa",
            "160985c4-1ff0-420f-95ea-1bc1473cba2c",
            "62581c1e-649c-40d3-b223-5e9c5f08ac00",
            "d9ce98b0-f0ab-43aa-a871-dcbd91f4c3c1",
            "d87f3f77-c8f0-4dfe-bee6-c33ed1809d97",
            "1ca55cb9-949c-4e25-8734-bee6e5aad255",
            "1e3c2828-3bbc-41bb-8f06-4cf472ec7b94",
            "475807fd-3811-4735-8886-332da9a97cea",
            "21562d92-57ea-4775-9eec-e0fce19561b4",
            "f392823d-0d90-4083-aec6-1a4642e9fbbe",
            "2404b68b-ca1a-4b1e-83e2-1b77704df11b",
            "25872228-48ae-422e-9584-2bbf67b496e6",
            "905d3129-c148-4849-9b6d-b331917d8a60",
            "6640c523-ab18-4d80-9433-2179fe7e6cc4",
            "be05ac13-4789-4212-8914-4b5cc4246bad",
            "6076bc62-210a-4e95-a7ac-3ef28d7751bd",
            "d6defb0d-0c28-409d-8b95-a80b23d6a365",
            "ee178ffd-cac8-415a-97ad-7bd884700c46",
            "c64ffc75-09d0-4344-9da9-f75f4ef62b37",
            "ef249014-a845-45c3-b917-dcb5294bd24d",
            "f79895a6-9e7d-4610-a43e-e57b88b748c4",
            "8cb95b78-7d30-4846-8e87-bccb68ba0eaa",
            "86d76fed-97dd-4e9a-b151-f1830e4e8754",
            "6e0d8067-e7fc-487f-834b-0184b3673da8",
            "baf5c299-1dda-466d-b2e5-814b2fddf1b2",
            "f80385db-d592-4288-8bda-554d59d33e1c",
            "a835102c-fe2c-4417-867a-7aa60334b105",
            "315a44d0-4e80-4e25-ac5f-eea56454a5d1",
            "9adbc044-6767-4b7f-9709-baeb71cf549f",
            "4d3026a8-480c-45e0-a27b-3fe8011b61df",
            "9d6d3824-6704-42a2-89ec-6d2eeb8e4aab",
            "339dbc0d-b5a1-4c4d-a561-42f5e4474edc",
            "974756bd-fd43-4498-b026-652b28b2f2fa",
            "a2a8dd5f-6b67-4095-aeec-11e4ca07044a",
            "45e537a5-ceba-43be-9dbb-161952496694",
            "8abd2061-a63c-434e-ba30-546cf8af3b37",
            "a01465dd-0129-4c8c-953b-49796c7ddefe",
            "8c79c27d-3208-4c05-b035-065b68b96514",
            "c92e5393-88c8-4016-868d-c4ee07ef48dc",
            "30d05fb4-b63a-473f-96b6-74f535bbacfc",
            "f1b2766f-f6d0-431c-a4a0-25807a347e9e",
            "f274e6f8-82fc-4681-85b1-4615d5a24aa5",
            "acf575fd-6dc8-4a4e-8fef-40b7fb97085f",
            "97d804bc-5e36-408c-b76f-96944eee871f",
            "99138282-df1d-47b4-8018-88cd22bdf22a",
            "f70bb934-d654-4934-a7b8-07f3c34f4c9f",
            "9bb68366-1f14-413f-9dbc-004160d68aa6",
            "38cb6dc2-1637-4a8d-a534-080fafa014d9",
            "9c9487ac-12b6-4850-8a56-dd59d1e9086e",
            "d0eace1c-d52e-4990-b372-3799958e6595",
            "2b7d8cea-91ed-428a-b2ab-dba9d6173924",
            "dcf67780-d287-4297-af67-f6c0f7c20d6c",
            "a241f070-79da-43eb-bc4b-222cedfe0430",
            "af42cc46-93e2-4bd8-a731-ca3dd35d52fa",
            "f4465b24-14da-4060-a1fa-570d0edab7b5",
            "d221b474-a26c-465c-92b5-7c9a4518216a",
            "b79a45f9-a3f4-4122-8c27-11bfb5caffb4",
            "f08bf515-fc87-49bc-8617-1c240441a941",
            "3a6d1e74-d734-41a6-9e37-0abfc318e365",
            "f29999c3-a5c7-4d51-a02d-7d56ef2e2563",
            "d5122277-1f6e-4e90-a656-bab00009c1c2",
            "df2ff34c-e8be-43aa-a1e2-53cebd7aef2f",
            "39134733-c121-4e7b-8117-245916932a69",
            "39b0382c-98a6-42cd-b0ee-e0d007f5c12e",
            "3e3483b9-7a49-4746-b21a-4cb36679c69f",
            "59546bed-2026-481c-9836-e76e903bb7ca",
            "414d0c3b-5975-47dc-8051-7b13140e9727",
            "ee385cf4-eddc-48fd-8c43-25886011375d",
            "fce39a78-c481-4464-a57a-f18fb43d91d7",
            "d25d6086-f0de-4260-86b2-dee26e5d6ee0",
            "fdd3a61d-3c9e-42d1-8360-4cbff78aba3a",
            "daf1a615-191c-40d1-9517-9ccbdf001838",
            "068a2ba2-66b6-4d0b-835c-e62b67617a01",
            "0b90f712-f5f4-4f99-a881-2ce800ec85fa",
            "b90ddf01-8f91-4d51-a601-986e50d6d49a",
            "0d2523f8-9d8a-4160-9fb6-38eaab2ea7be",
            "76e5c07b-881e-4371-8511-5fc93a470f5c",
            "f783058e-4989-42ff-a6d5-3dac2bd0bc34",
            "1ce2a605-f525-452b-acc1-d8e09b52ba58",
            "240053ac-7dda-41b1-a32e-7e45a2c00632",
            "d85ede7f-3cdd-4972-9419-04aa1a59136e",
            "dc79f8e1-fd3f-4940-92f6-b8381d63ac16",
            "fdba75d2-5e74-474b-adbb-ecec06143302",
            "dddcd131-415c-4f48-9f04-0a9f93915d75",
            "e19405b8-fdb2-4b0c-8109-c8a7562bffd4",
            "f3ccadf7-7e15-45c0-81c4-a1430a8fbf8b",
            "f9c0722f-920f-4cd1-af8e-e8425d7f098f",
            "fb8d1a05-701c-4c1f-8ce3-9378ed550318",
            "fd9d73cd-b045-43d9-b2e5-a847edd59869",
            "9ab49af8-8625-478b-ac06-76c340b4d03c",
            "de027172-d682-45d2-976d-cc11779eeb76",
            "67884e6b-468e-4056-b692-e2134f7d877d",
            "d46311f1-68ce-461e-a59e-41dcf0a5dbce",
            "501708c7-4199-414c-ad6a-95cb1eb4ff06",
            "672a6b2c-7185-4805-99e0-49c49aa36ad7",
            "e6cb9b5c-b0d4-43f5-98d0-eb5d73aff1cf",
            "faeed442-0c17-45d3-9f09-5278bc6b8022",
            "b45b301c-4368-4c51-9479-b1b02bd3dc09",
            "bba83847-c066-4250-a7b5-7f550d8a0305",
            "b2755df1-9ace-474b-9302-f8e9c8a683eb",
            "c8aa6ee2-1255-470c-8d01-3177528c5ca0",
            "ca4a3feb-6953-4418-bc35-99d14ba9cc92",
            "4dafab4c-222c-4711-b3ed-8805fe9310e2",
            "e59863ea-245f-41c5-9aca-cd5ac315e001",
            "fb475f4a-496e-4fec-8b38-d2b427e4124a",
            "581b693e-dd0a-4ecd-b57f-eb7779888473",
            "10407f7e-8143-4fa7-81d0-e910f570135c",
            "a06d6cf4-cec8-45c6-b850-e3ed355b37bc",
            "fc4a9bbd-0631-4045-8ab6-a2b546a6ed85",
            "103350d5-1443-46c6-9fff-bcbabb83477f",
            "ea875be1-a404-45e7-b04a-6630e2f978b5",
            "cd11110e-17ee-4ff8-932e-6aa21a01d437",
            "bef781ce-dab4-4e31-952c-7c58c962cd69",
            "f8d34847-b6f9-4ed5-8d8c-d2208e8c96e2",
            "9ed25c25-299d-422b-9059-31590526a934",
            "bde89fb5-244e-43ae-a882-72220c5c824f",
            "4cacbef2-6d7e-4a38-82c1-b1224d96f84b",
            "86224edf-f3b5-4773-bb19-381246c3d472",
            "a723758b-493d-494a-aafc-a439881e5bb9",
            "dbcb05f7-9fbe-4a9a-92f7-9c92fafb1676",
            "9bc064df-d6e4-4064-b1b2-86e3d4091b75",
            "2bbb7a1a-64d3-4f1b-b0b5-ce7920a2ebce",
            "bd55d4af-bf71-4d50-ab30-dd893ad65533"};

    public static void main(String[] args) {
        SpringApplication.run(TestClientApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(SbxCloudFindService sbxCloudFindService) {

        return args -> {

            Optional<Rows<CartBoxItem>> response = Optional.ofNullable(sbxCloudFindService.loadPage(new ParameterizedTypeReference<Rows<CartBoxItem>>() {
            }).block());

            response.ifPresent(res -> {
                Arrays.stream(res.getResults()).forEach(box -> {
                    System.out.println("======");
                    System.out.print("Apunta a inventario borrado? => ");
                    System.out.println(!Arrays.stream(keys).filter(k -> box.getInventory().equals(k)).collect(toList()).isEmpty());
                    System.out.println("box_item:" + box.getKey() + "->" + "inv:" + box.getInventory());
                });
            });

        };

    }


}



