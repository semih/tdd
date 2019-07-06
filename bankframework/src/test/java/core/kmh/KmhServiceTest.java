package core.kmh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KmhServiceTest {

    IKmhService kmhService;
    @BeforeEach
    void setUp() {
        kmhService=new KmhService();
    }

    @Test
    @DisplayName("Should  throw Exception if Not OverDraft")
    void testCheckKMHAccount() {

        assertThrows(Exception.class, () -> kmhService.getKMHMethod(3),"Account is Not OverDraft");
    }

    @ParameterizedTest(name="{index} => {0}")
    @MethodSource("stringIntAndListProvider")
    @DisplayName("Should Return Valid KMH Metod")
    void test(int accountNumber,String expectedMetodName) throws Exception {

        String metod=kmhService.getKMHMethod(accountNumber);
        assertEquals(expectedMetodName,metod);
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments(1, "CFN"),
                arguments(2, "GUNICI")
        );
    }
}