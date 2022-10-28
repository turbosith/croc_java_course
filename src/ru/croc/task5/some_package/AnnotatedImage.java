package ru.croc.task5.some_package;

class AnnotatedImage {

    private final String imagePath;

    private final Annotations[] annotations;

    public AnnotatedImage(String imagePath, Annotations... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotations[] getAnnotations() {
        return this.annotations;
    }
}

