package train;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.collections4.KeyValue;

import java.util.Collection;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

@Data
@Builder
@EqualsAndHashCode(exclude = {"age"})
class People {
    private String name;
    private int age;
    private String sex;
}

public class Main {
    public static void main(String[] args) throws Exception {
        Set<People> peopleSet = new TreeSet<>((o1, o2) -> {
            if (o1.getAge() != o2.getAge()) {
                return o1.getAge() - o2.getAge();
            }
            return 1;
        });
        peopleSet.add(People.builder().name("zhangsan").age(10).sex("male").build());
        peopleSet.add(People.builder().name("lisi").age(20).sex("female").build());
        peopleSet.add(People.builder().name("wangwu").age(30).build());
        peopleSet.add(People.builder().name("zhangsan").age(30).sex("male").build());

        peopleSet.stream().reduce((a, b) -> People.builder().age(a.getAge() + b.getAge()).build());


        LinkedBlockingQueue<People> peopleQueue = new LinkedBlockingQueue<>();
        peopleQueue.poll();
        peopleQueue.take();
    }

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }


}