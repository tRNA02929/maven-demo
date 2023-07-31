package org.example;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {
        Optional.ofNullable(1).map(i -> Integer.toString(i));
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        Student student = Student.builder().name("zhangsan").student_id(1).build();
        System.out.println(student);
    }

    //    public static List<EBSVolume> pickEbsVolumes(CreateKciParam param) {
//        return Optional.ofNullable(param.getVolume())
//                .filter(CollectionUtils::isNotEmpty)
//                .map(l -> l.stream()
//                        .filter(e -> StringUtils.equalsIgnoreCase(e.getType(), VolumeKind.EBSVolume.name()))
//                        .map(VolumeParam::getEBSVolume)
//                        .collect(Collectors.toList()))
//                .filter(CollectionUtils::isNotEmpty)
//                .orElse(null);
//    }
    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }


}