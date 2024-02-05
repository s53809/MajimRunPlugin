package org.example;

public class Vector3 {
    public double x, y, z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 Add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3 Minus(Vector3 other){
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3 Normalized(){
        double mag = this.magnitude();
        return new Vector3(this.x / mag, this.y / mag, this.z / mag);
    }

    // 다른 필요한 메서드들을 추가할 수 있습니다 (ex: subtract, multiply, normalize 등)

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
